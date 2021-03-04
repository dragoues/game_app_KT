package com.example.myapplicationgamekt



class GameObjects : Destructible {
    override fun takeHit(attackPower: Int) {}
    override val isDestroyed: Boolean
        get() = false

    fun postAlert(message: String?) {}
}