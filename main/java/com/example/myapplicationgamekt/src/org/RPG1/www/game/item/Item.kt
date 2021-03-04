package com.example.myapplicationgamekt

abstract class Item(val name: String, val bonus: Int, val itemKind: KindOfItem) :
    org.academiadecodigo.www.game.GameObjects() {
    override fun toString(): String {
        return name
    }
}