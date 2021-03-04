package com.example.myapplicationgamekt

interface Destructible {
    fun takeHit(attackPower: Int)
    val isDestroyed: Boolean
}