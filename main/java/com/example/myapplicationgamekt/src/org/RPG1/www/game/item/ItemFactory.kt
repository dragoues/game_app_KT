package com.example.myapplicationgamekt


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
                ItemType.BASIC_AXE -> itemList
                ItemType.BREAD -> itemList
                ItemType.CLOTH -> itemList
                ItemType.STICK -> itemList
                ItemType.TORCH -> itemList
                ItemType.SCROLL -> itemList
                ItemType.BASIC_SHIELD -> itemList
                ItemType.SMALL_ROCK -> itemList
                ItemType.RUSTY_KNIFE -> itemList
                ItemType.LIGHTED_TORCH -> itemList
                ItemType.PILE_OF_LEAVES -> {
                    itemList.run {
                        add(

                                )
                    }
                }
                else -> println("Something went really wrong...")
            }
        }
    }

    private fun add() {
        TODO("Not yet implemented")
    }

    /**
     * Returns a list of Items.
     * @return          Returns the list of Items created.
     */
    fun getItemList(): List<Item> {
        return itemList
    }

    init {
        itemList = ArrayList()
    }
}