package org.academiadecodigo.www.game.item

import java.util.*

class ItemFactory {
    private val itemList: MutableList<Item>

    /**
     * @param itemType      The type of Item.
     * @param quantity      The quantity of Items to create.
     */
    fun createItem(itemType: ItemType?, quantity: Int) {
        for (i in 0 until quantity) {
            when (itemType) {
                ItemType.BASIC_AXE -> itemList.also {  }
                ItemType.BREAD -> itemList.also {  }
                ItemType.CLOTH -> itemList.also {  }
                ItemType.STICK -> itemList.also {  }
                ItemType.TORCH -> itemList.also {  }
                ItemType.SCROLL -> itemList.also {  }
                ItemType.BASIC_SHIELD -> itemList.also {  }
                ItemType.SMALL_ROCK -> itemList.also {  }
                ItemType.RUSTY_KNIFE -> itemList.also {  }
                ItemType.LIGHTED_TORCH -> itemList.also {  }
                ItemType.PILE_OF_LEAVES -> itemList.also {  }
                else -> println("Something went really wrong...")
            }
        }
    }

    /**
     * Returns a list of Items.
     * @return          Returns the list of Items created.
     */
    fun getItemList(): List<Item> {
        return itemList
    }

    init {
        itemList = ArrayList<Item>()
    }
}