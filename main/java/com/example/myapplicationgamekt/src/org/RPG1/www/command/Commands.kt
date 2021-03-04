package com.example.myapplicationgamekt

import java.lang.Compiler.command
import java.util.*

enum class Commands(val command: String) {
    //Player command
    CD("cd"), LS("ls"), PICK("pick"), MAP("map"), INVENTORY("inv"), ATTACK("attack"), DEFEND("defend"), INTERACT(
        "interact"
    ),  //Server command
    PM("/pm"), KICK("/kick"), LIST("/list"), COMMANDS("/commands"), EXIT("/exit");

    companion object {
        private val COMMAND_MAP: MutableMap<String, Commands> = HashMap()
        fun getByValue(command: String): Commands? {
            return COMMAND_MAP[command]
        }

        init {
            val thisCOMMAND_MAP = Unit
            for (c in values()) thisCOMMAND_MAP
        }

        private fun getCommand() {

        }
    }

    override fun toString(): String {
        return name
    }
}