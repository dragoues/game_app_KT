package com.example.myapplicationgamekt

interface Playable {
    val health: Int
    fun getInstruction(instruction: String?): String?
    val isDead: Boolean
}