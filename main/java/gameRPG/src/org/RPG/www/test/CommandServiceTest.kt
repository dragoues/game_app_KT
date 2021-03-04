package org.academiadecodigo.www.test

/**
 * Created by oem on 22-07-2017.
 */
object CommandServiceTest {
    @JvmStatic
    fun main(args: Array<String>) {
        println(org.academiadecodigo.www.command.Commands.Companion.getByValue("/pm"))
    }
}