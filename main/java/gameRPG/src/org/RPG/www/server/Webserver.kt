package org.academiadecodigo.www.server

import org.academiadecodigo.www.command.Commands
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.Executors

class Webserver {
    private val PORT = 6969
    private val commandParser: org.academiadecodigo.www.command.CommandParser
    private val fileManager: org.academiadecodigo.www.FileManager

    //State: Shared and mutable
    private var list: CopyOnWriteArrayList<ClientHandler>? = null
    private fun start() {
        try {
            list = CopyOnWriteArrayList()
            val serverSocket = ServerSocket(PORT)
            println("****** SERVER OPENED PORT: $PORT ******\n")
            while (true) {
                val clientSocket = serverSocket.accept()

                //Puts Client in Blocking List
                val currentClientHandler: ClientHandler = ClientHandler(clientSocket)
                list!!.add(currentClientHandler)
                val fixedPool = Executors.newFixedThreadPool(10)
                fixedPool.submit(currentClientHandler)
            }
        } catch (e: IOException) {
            System.err.println("****** SOCKET CLOSED ****** " + e.message)
        }
    }

    private fun sendAll(msg: String) {
        for (c in list!!) {
            c.send(msg)
        }
    }

    private inner class ClientHandler(private val clientSocket: Socket) :
        Runnable {
        private var userName = ""
        private val password = ""
        override fun run() {
            try {
                val `in` = BufferedReader(
                    InputStreamReader(
                        clientSocket.getInputStream()
                    )
                )

                //Username Check
                var username = ""
                while (username.trim { it <= ' ' } == "") {
                    send("Please Insert your Username:")
                    username = `in`.readLine()
                    username = validate(username)
                }
                userName = username

                /*//Password Check
                String password = "";
                while (password.trim().equals("")) {
                    send("Please Enter your Password:");
                    password = in.readLine();

                    password = validateP(password);
                }
                this.password = password;

                //File Check Users
                if (!checkUser()) {
                    fileManager.write("users", userName + ":" + password);
                }*/logInMessage()

                //Begin Game Thread
                var msg: String? = ""
                while (true) {
                    msg = `in`.readLine()
                    if (msg == null) {
                        println("\n****** $userName: logged out ******")
                        removeFromList()
                        break
                    }
                    if (msg.trim { it <= ' ' } == "") {
                        continue
                    }
                    handle(msg)
                }
            } catch (e: IOException) {
                System.err.println("****** FAILED TO RECEIVE MESSAGE ****** " + e.message)
            }
        }

        /**
         * Remove client from the list
         */
        private fun removeFromList() {
            list!!.remove(this)
        }

        /**
         * Method to validate a user name in the register
         * @param userName                  String
         * @return                          String
         */
        private fun validate(userName: String): String {
            if (userName.split(" ").toTypedArray().size > 1) {
                send("Your Username can't contain blank spaces")
                return ""
            }
            if (userName.length > 10) {
                send("Your Username has to be less than 10 characters")
                return ""
            }
            for (ch in list!!) {
                if (ch.userName == userName) {
                    send("This username already exists")
                    return ""
                }
            }
            return userName
        }

        /**
         * Simple message when user logs in
         */
        private fun logInMessage() {
            send("****** Your username is: $userName ******")
            println("****** $userName: logged in ******")
            sendAll("****** $userName logged in ******")
        }

        /**
         * Lists all clients logged in
         */
        private fun listClients() {
            for (ch in list!!) {
                send(ch.userName)
            }
        }
        /**
         * TODO: Need to think about this
         * private String validateP(String password) {
         * if (password.length() > 10) {
         * send("Your Password has to be less than 10 characters");
         * return "";
         * }
         *
         *
         * if (!this.password.equals(password)) {
         * send("Wrong password");
         * return "";
         * }
         *
         * return password;
         * } */
        /**
         * TODO: Check if users already logged in, (saved in a file)
         * private boolean checkUser() {
         *
         * try {
         * String user = fileManager.read("users");
         * String[] line = user.split("\n");
         * String[] users;
         *
         * for (int i = 0; i < line.length; i++) {
         * users = line[i].split(":");
         * if (line[i].equals(userName)) {
         * System.out.println(list.get(i).userName);
         * return true;
         * }
         * }
         *
         * } catch (IOException e) {
         * System.err.println("File not found!" + e.getMessage());
         *
         * }
         *
         * return false;
         *
         * } */
        /**
         * Handles command actions
         * @param msg       String
         */
        private fun handle(msg: String) {
            commandParser.split(msg)
            val command: Commands? =
                org.academiadecodigo.www.command.Commands.Companion.getByValue(commandParser.getCommand())
            if (command == null) {
                sendAll("< " + userName + "_> " + msg)
                return
            }
            when (command) {
                org.academiadecodigo.www.command.Commands.PM -> sendPrivate(
                        commandParser.getActionCommand().toString(),
                        commandParser.getText().toString()
                )
                org.academiadecodigo.www.command.Commands.LIST -> listClients()
                org.academiadecodigo.www.command.Commands.COMMANDS -> listCommands()
                org.academiadecodigo.www.command.Commands.KICK -> {
                }
                org.academiadecodigo.www.command.Commands.EXIT -> {
                    send("****** LOGING OUT ******")
                    removeFromList()
                }
            }
        }

        /**
         * Lists all commands
         */
        private fun listCommands() {
            for (c in org.academiadecodigo.www.command.Commands.values()) {
                send(c.getCommand().toString())
            }
        }

        /**
         * Send a private message to a specific user
         * @param username                  String
         * @param msg                       String
         */
        private fun sendPrivate(username: String?, msg: String) {
            for (ch in list!!) {
                if (ch.userName == username) {
                    try {
                        val out = PrintWriter(ch.clientSocket.getOutputStream(), true)
                        out.println("private message: < " + userName + "_> " + msg)
                        return
                    } catch (e: IOException) {
                        System.err.println("Found a problem with the client socket" + e.message)
                    }
                }
                send("Couldn't find that user")
            }
        }

        /**
         * Send a reply of the message
         * @param msg           String
         */
        fun send(msg: String) {
            try {
                val out = PrintWriter(clientSocket.getOutputStream(), true)
                out.println(msg)
            } catch (e: IOException) {
                System.err.println("****** FAILED TO WRITE MESSAGE ****** " + e.message)
            }
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val webserver = Webserver()
            webserver.start()
        }
    }

    init {
        commandParser = org.academiadecodigo.www.command.CommandParser()
        fileManager = org.academiadecodigo.www.FileManager()
    }
}