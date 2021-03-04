package org.academiadecodigo.www.client

import java.util.*

class Player : Client() {
    private val inventory: MutableList<org.academiadecodigo.www.game.item.Item>
    var mapZones: org.academiadecodigo.www.game.map.MapZones? = null
    fun addToInventory(item: org.academiadecodigo.www.game.item.Item) {
        inventory.add(item)
    }

    fun removeFromInvetory(itemName: String) {
        for (i in inventory) {
            if (i.getName() == itemName) {
                inventory.remove(i)
            }
        }
    }

    fun listInventory() {
        for (i in inventory) {
            println(i.getName())
        }
    }

    init {
        inventory = LinkedList<org.academiadecodigo.www.game.item.Item>()
    }
}