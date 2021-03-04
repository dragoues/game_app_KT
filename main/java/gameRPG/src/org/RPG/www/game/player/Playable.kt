package org.academiadecodigo.www.game.player

interface Playable {
    val health: Int
    fun getInstruction(instruction: String?): String?
    fun setHealth(any: Any)
    abstract fun getHealth(): Any

    fun isDead(): Boolean
}