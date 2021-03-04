package org.academiadecodigo.www.test

import java.io.IOException
import java.util.*

private val Unit.size: Unit
    get() = Unit

/**
 * Created by oem on 22-07-2017.
 */
object StoryLineParserTest {
    @JvmStatic
    fun main(args: Array<String>) {
        var storyIndex = 0
        val storyParser: org.academiadecodigo.www.game.story.StoryLineParser =
            org.academiadecodigo.www.game.story.StoryLineParser()
        val fileManager: org.academiadecodigo.www.FileManager =
            org.academiadecodigo.www.FileManager()
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
        while (storyIndexcompareTo(storyParser.getLine().size) < 0) {
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

    private fun storyIndexcompareTo(size: Unit) {

    }
}

 operator fun Any.compareTo(i: Int): Int {
     return 0
 }
