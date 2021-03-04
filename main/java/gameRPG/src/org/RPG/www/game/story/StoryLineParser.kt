package org.academiadecodigo.www.game.story

class StoryLineParser {
    var line: Array<String>? = null
        get() {
            TODO()
        }
        private set

    /**
     * Splits a String
     * @param text    String type
     */
    fun split(text: String) {
        line = text.split("\n").toTypedArray()
    }

    /**
     * Returns a line
     * @return          String type
     */
    fun getLineFrom(number: Int): String? {
        return if (line == null) {
            null
        } else line!![number]
    }

    fun getLine() {

    }
}