package org.academiadecodigo.www.game.item

abstract class Item(val name: String, val bonus: Int, itemKind: KindOfItem) :
    org.academiadecodigo.www.game.GameObjects() {
    private val itemKind: KindOfItem
    fun getItemKind(): KindOfItem {
        return itemKind
    }

    override fun toString(): String {
        return name
    }

    init {
        this.itemKind = itemKind
    }
}