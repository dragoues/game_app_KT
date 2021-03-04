package com.example.myapplicationgamekt
class CommandParser {
    private var command: Array<String>? = null

    /**
     * Returns a phrase
     * @return          String type
     */
    var text = ""
        get() {
            field = ""
            for (i in 2 until command!!.size) {
                field = field + command!![i] + " "
            }
            return field
        }
        private set

    /**
     * Splits a String
     * @param command    String type
     */
    fun split(command: String) {
        if (command == "" || command.trim { it <= ' ' }.isEmpty()) {
            println("****** command not Found ******")
            return
        }
        if (command.split(" ").toTypedArray().size == 0) {
            this.command!![0] = command
            return
        }
        this.command = command.split(" ").toTypedArray()
    }

    /**
     * Returns a command
     * @return          String type
     */
    fun getCommand(): String? {
        return if (command == null) {
            null
        } else command!![0]
    }

    /**
     * Returns an Action
     * @return          String type
     */
    val actionCommand: String?
        get() = if (command!!.size == 1) {
            null
        } else command!![1]
}