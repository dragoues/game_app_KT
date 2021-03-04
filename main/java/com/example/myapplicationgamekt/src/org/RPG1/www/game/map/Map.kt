package com.example.myapplicationgamekt

import org.academiadecodigo.www.game.story.StoryLineParser
import java.io.IOException
import java.util.*

private val String.size: Unit
    get() = Unit
private val Int.storyParser: Any
    get() = Unit
private val Unit.size: Unit
    get() = Unit

abstract class Map(
    val mapZones: MapZones,
    enemies: List<org.academiadecodigo.www.game.enemy.Enemy>,
    items: List<org.academiadecodigo.www.game.item.Item>
) : org.academiadecodigo.www.game.story.StoryLine {
    private val items: List<org.academiadecodigo.www.game.item.Item>
    private val enemies: List<org.academiadecodigo.www.game.enemy.Enemy>
    var mapBlocker = true
    fun getEnemies(): List<org.academiadecodigo.www.game.enemy.Enemy> {
        return enemies
    }

    fun getItems(): List<org.academiadecodigo.www.game.item.Item> {
        return items
    }

    override fun toString(): String {
        return "Map{" +
                "mapZones=" + mapZones +
                ", items=" + items +
                ", enemies=" + enemies +
                ", mapBlocker=" + mapBlocker +
                '}'
    }

    override fun initStoryLine() {
        val fileManager: org.academiadecodigo.www.FileManager =
            org.academiadecodigo.www.FileManager()
        val storyParser: org.academiadecodigo.www.game.story.StoryLineParser =
            org.academiadecodigo.www.game.story.StoryLineParser()
        var fileContent = ""
        try {
            fileContent = fileManager.read(mapZones.name)
        } catch (e: IOException) {
            System.err.println("Failed to read file " + e.message)
        }
        storyParser.split(fileContent)
        println("Press [ENTER] to continue")
        when (mapZones) {
            MapZones.HOME -> home(storyParser)
            MapZones.PLAIN -> {
            }
            MapZones.FOREST -> {
            }
            MapZones.ICY_PEAK -> {
            }
            MapZones.MOUNTAIN -> {
            }
        }
    }

    private fun home(storyParser: StoryLineParser) {
        var storyIndex = 0
        val sc = Scanner(System.`in`)
        var s = ""
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

    init {
        this.items = items
        this.enemies = enemies
    }
}




