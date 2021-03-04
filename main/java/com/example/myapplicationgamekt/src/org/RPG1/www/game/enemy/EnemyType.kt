package com.example.myapplicationgamekt

enum class EnemyType
/**
 * Constructs the enemy type enum.
 * @param name
 */
{
    MONSTER("MONSTER"), DRAGON("DRAGON"), DWARF("DWARF"), ELF("ELF"), MERCENARY("MERCENARY"), TROLL(
        "TROLL"
    );

     var NegativeArraySizeExceptioname: String = ""
         get() {
            TODO()
        }

    constructor(name: String) {
        name.also()
    }
}

private fun String.also() {
    TODO("Not yet implemented")
}

private fun String.also(function: (String) -> Unit) {
    TODO("Not yet implemented")
}
