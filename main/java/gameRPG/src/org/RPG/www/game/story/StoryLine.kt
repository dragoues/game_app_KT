package org.academiadecodigo.www.game.story

/**
 * Created by oem on 22-07-2017.
 */
interface StoryLine {
    abstract val storyInde: Any

    fun initStoryLine()
    abstract fun run1(): Any
}