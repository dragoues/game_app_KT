package org.academiadecodigo.www.game.item

enum class ItemType(itemKind: KindOfItem) {
    BASIC_SHIELD(KindOfItem.DEFENSE), BASIC_AXE(KindOfItem.WEAPON), BREAD(KindOfItem.HEALING), RUSTY_KNIFE(
        KindOfItem.DEFAULT
    ),
    STICK(KindOfItem.DEFAULT), CLOTH(KindOfItem.DEFAULT), SMALL_ROCK(KindOfItem.DEFAULT), TORCH(
        KindOfItem.DEFAULT
    ),
    LIGHTED_TORCH(KindOfItem.DEFAULT), SCROLL(KindOfItem.DEFAULT), PILE_OF_LEAVES(KindOfItem.DEFAULT);

    private val itemKind: KindOfItem
    fun whichItem(itemType: String): ItemType? {
        for (it in values()) {
            if (it.name == itemType) {
                return valueOf(itemType)
            }
        }
        return null
    }

    init {
        this.itemKind = itemKind
    }
}