package com.example.myapplicationgamekt

import org.academiadecodigo.www.FileManager
import org.academiadecodigo.www.game.story.StoryLineParser
import java.io.IOException
import java.util.*

private val String.size: Unit
    get() = Unit
private val Int.storyParser: Any
    get() = Unit
private val Unit.size: Unit
    get() = Unit


object StoryLineParserTest {
    @JvmStatic
    fun main(args: Array<String>) {
        var storyIndex = 0
        val storyParser: StoryLineParser =
            StoryLineParser()
        val fileManager: FileManager =
            FileManager()
        var home = ""
        try {
            home = fileManager.read("home")
        } catch (e: IOException) {
            System.err.println("Failed to read file " + e.message)
        }
        storyParser.split(home)
        val sc = Scanner(System.`in`)
        var s: String
        println("Press [ENTER] to continue")
         {
            print(storyParser.getLineFrom(storyIndex++))
            s = sc.nextLine()
            if (storyIndex == 10) {
                while (s != "/commands") {
                    s = sc.nextLine()
                }
            }
            if (storyIndex == 14) {
                while (s != "ls") {
                    s = sc.nextLine()
                }
            }
            if (storyIndex == 21) {
                while (s != "interact" && s != "pick" && s != "attack") {
                    s = sc.nextLine()
                }
            }
        }
    }

    private fun println(s: String, function: () -> Unit) {

    }
}