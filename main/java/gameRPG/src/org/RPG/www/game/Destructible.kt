package org.academiadecodigo.www.game

interface Destructible {
    fun takeHit(attackPower: Int)
    abstract fun getName(): Any
    fun getBonus(): Byte
    fun isDestroyed(): Boolean


}