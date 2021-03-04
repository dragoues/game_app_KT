package com.example.myapplicationgamekt
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket
import java.util.*
import java.util.concurrent.Executors

open class Client {
    private val PORT = 6969
    private val HOST = "localhost"
    private val commandParser: org.academiadecodigo.www.command.CommandParser
    fun start() {
        try {
            val clientSocket = Socket(HOST, PORT)
            println("****** CLIENT CONNECTED TO HOST: " + HOST + " PORT: " + clientSocket.port + " ******")
            val `in` = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
            var msg: String?
            val fixedPool = Executors.newFixedThreadPool(4)
            fixedPool.submit(ClientRunnable(clientSocket))
            while (true) {
                msg = `in`.readLine()
                if (msg == null) {
                    Thread.currentThread().interrupt()
                    clientSocket.close()
                    System.exit(-1)
                }
                println(msg)
            }
        } catch (e: IOException) {
            System.err.println("****** SOCKET CLOSED ****** " + e.message)
        }
    }

    private inner class ClientRunnable(private val clientSocket: Socket) : Runnable {
        override fun run() {
            try {
                val out = PrintWriter(clientSocket.getOutputStream(), true)
                while (true) {
                    val message = message
                    out.println(message)
                    commandHandler(message)
                }
            } catch (e: IOException) {
                System.err.println("****** FAILED TO WRITE MESSAGE ****** " + e.message)
            }
        }

        private val message: String
            private get() {
                val reader = Scanner(System.`in`)
                return reader.nextLine()
            }

        private fun commandHandler(message: String) {
            commandParser.split(message)
            val command: org.academiadecodigo.www.command.Commands =
                org.academiadecodigo.www.command.Commands.Companion.getByValue(commandParser.getCommand())
                    ?: return
            when (command) {
                org.academiadecodigo.www.command.Commands.CD -> println("CD")
                org.academiadecodigo.www.command.Commands.LS -> println("LS")
                org.academiadecodigo.www.command.Commands.MAP -> println("MAP")
                org.academiadecodigo.www.command.Commands.PICK -> println("PICK")
                org.academiadecodigo.www.command.Commands.INTERACT -> println("INTERACT")
                org.academiadecodigo.www.command.Commands.INVENTORY -> println("INVENTORY")
                org.academiadecodigo.www.command.Commands.ATTACK -> println("ATTACK")
                org.academiadecodigo.www.command.Commands.DEFEND -> println("DEFEND")
                org.academiadecodigo.www.command.Commands.EXIT -> {
                    Thread.currentThread().interrupt()
                    System.exit(-1)
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val client = Client()
            client.start()
        }
    }

    init {
        commandParser = org.academiadecodigo.www.command.CommandParser()
    }
}