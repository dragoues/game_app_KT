package org.academiadecodigo.www.game.enemy

enum class EnemyType
/**
 * Constructs the enemy type enum.
 * @param name
 */
{
    MONSTER("MONSTER"), DRAGON("DRAGON"), DWARF("DWARF"), ELF("ELF"), MERCENARY("MERCENARY"), TROLL(
        "TROLL"
    );

    constructor(name: String) {
        name.also { it.also()
    }
}

    private fun String.also() {
        TODO("Not yet implemented")
    }



    }