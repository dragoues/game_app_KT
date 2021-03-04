package com.example.myapplicationgamekt

import java.util.*

abstract class Player(

    val name: String
) : Playable {
    override var health = 100
    var attackingPower = 1
        private set
    var shield = 0
        private set
    private val inventory: ArrayList<org.academiadecodigo.www.game.item.Item>
    private var dead = false

    /**
     * Player attacks and sets a casedDamage to be accessed by the Game
     *
     * @param destructible
     */
    fun attack(destructible: org.academiadecodigo.www.game.Destructible) {
        if (destructible.isDestroyed()) {
            println("Enemy is already dead")
            return
        }
        destructible.takeHit(attackingPower)
    }

    /**
     * Player defends from de attacking power from the Destructibles
     */
    private fun defend(monsterAttackPower: Int) {
        if (!isDead) {
            shield -= monsterAttackPower
            if (shield <= 0) {
                takeHit(Math.abs(shield))
            }
        }
    }

    fun takeHit(monsterAttackPower: Int) {
        if (health <= 0) {
            return
        }
        if (shield > 0) {
            defend(monsterAttackPower)
            return
        }
        health -= monsterAttackPower
    }

    /**
     * Lists Player inventory and the item index to use in equipGear() method
     */
    fun listInventory() {
        if (inventory.size == 0) {
            println("I have nothing in my inventory")
            return
        }
        for (i in inventory.indices) {
            println(inventory[i].toString() + " INDEX: " + i)
        }
    }

    /**
     * Interact with Item and set it to use
     *
     * @param index
     */
    fun equipGear(index: Int) {
        if (index < inventory.size && index >= 0) {
            if (inventory[index].getItemKind() === org.academiadecodigo.www.game.item.KindOfItem.WEAPON) {
                upgradeAttackingPower(index)
                return
            }
            if (inventory[index].getItemKind() === org.academiadecodigo.www.game.item.KindOfItem.DEFENSE) {
                upgradeBasicDefense(index)
                return
            }
            if (inventory[index].getItemKind() === org.academiadecodigo.www.game.item.KindOfItem.HEALING) {
                upgradeHealthValue(index)
                return
            }
            println("I can't use that item.")
            return
        }
        println("There's nothing in this slot.")
    }

    /**
     * TODO: NEED TO THINK ABOUT THIS
     */
    fun unequip() {}

    /**
     * reset player stats and inventory when player is dead
     * TODO: Health and shield should be variable. They depend on the bonuses
     */
    private fun rest() {
        health = 100
        shield = 0
    }

    /**
     * Updates player shield value
     *
     * @param index ArrayList index value
     */
    private fun upgradeBasicDefense(index: Int) {
        shield = shield + inventory[index].getBonus()
        println(inventory[index].toString() + " is equiped")
        println("Your basic defense is now $shield")
    }

    /**
     * Updates player attacking power value
     *
     * @param index ArrayList index value
     */
    private fun upgradeAttackingPower(index: Int) {
        attackingPower = attackingPower + inventory[index].getBonus()
        println(inventory[index].toString() + " is equiped")
        println("Your power attack is now up to $attackingPower Health Points")
    }

    /**
     * Updates player health value
     *
     * @param index ArrayList index value
     */
    private fun upgradeHealthValue(index: Int) {
        health = health + inventory[index].getBonus()
        println("You have been healed")
        println("Your health is now $health")
    }

    /**
     * Adds an item to the player inventory
     *
     * @param item
     */
    fun addToInventory(item: org.academiadecodigo.www.game.item.Item) {
        inventory.add(item)
        println("Added $item to my inventory")
    }

    override fun getInstruction(instructions: String?): String? {
        return null
    }

    /**
     * @return if player is dead or not
     */
    val gmaover: Boolean
        get() {
            return health <= 0
        }

    /**
     * When player is dead, set it to true
     *
     * @param dead
     */
    fun setDead(dead: Boolean) {
        this.dead = dead
    }

    /**
     * @return players properties
     */
    override fun toString(): String {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attacking power: " + attackingPower +
                ", basic defense: " + shield +
                ", inventory: " + inventory +
                '}'
    }

    /**
     * Different places where players can be moved
     *
     * @param direction where player can move
     */
    fun move(direction: String?) {
        when (direction) {
            "north" -> println("You moved NORTH")
            "south" -> println("You moved SOUTH")
            "west" -> println("You moved WEST")
            "east" -> println("You moved EAST")
            else -> println("Not a valid direction")
        }
    }

    /**
     * What directions are available for players to take
     */
    enum class Directions(private val direction: String) {
        NORTH("north"), SOUTH("south"), WEST("west"), EAST("east");
    }

    init {
        inventory = ArrayList<org.academiadecodigo.www.game.item.Item>()
    }
}