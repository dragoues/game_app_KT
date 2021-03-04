package com.example.myapplicationgamekt

enum class ItemType(private val itemKind: KindOfItem) {
    BASIC_SHIELD(KindOfItem.DEFENSE), BASIC_AXE(KindOfItem.WEAPON), BREAD(KindOfItem.HEALING), RUSTY_KNIFE(
        KindOfItem.DEFAULT
    ),
    STICK(KindOfItem.DEFAULT), CLOTH(KindOfItem.DEFAULT), SMALL_ROCK(
        KindOfItem.DEFAULT
    ),
    TORCH(KindOfItem.DEFAULT), LIGHTED_TORCH(KindOfItem.DEFAULT), SCROLL(
        KindOfItem.DEFAULT
    ),
    PILE_OF_LEAVES(KindOfItem.DEFAULT);

    fun whichItem(itemType: String): ItemType? {
        for (it in values()) {
            if (it.name == itemType) {
                return valueOf(itemType)
            }
        }
        return null
    }
}