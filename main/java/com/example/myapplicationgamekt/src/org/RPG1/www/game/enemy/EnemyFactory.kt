package com.example.myapplicationgamekt

import org.academiadecodigo.www.game.enemy.Enemy
import java.util.*

class EnemyFactory {
    private val enemyList: MutableList<Enemy>

    /**
     * Creates a specified quantity of enemy, of a specified enemy type.
     * @param enemyType         The type of Enemy.
     * @param quantity          The quantity of Enemies to create.
     */
    fun createEnemy(enemyType: EnemyType?, quantity: Int) {
        for (i in 0 until quantity) {
            when (enemyType) {
                EnemyType.MONSTER -> enemyList.add(Enemy(EnemyType.MONSTER, 7, 2, 7))
                EnemyType.DRAGON -> enemyList.add(Enemy(EnemyType.DRAGON, 12, 12, 16))
                EnemyType.DWARF -> enemyList.add(Enemy(EnemyType.DWARF, 5, 1, 3))
                EnemyType.ELF -> enemyList.add(Enemy(EnemyType.ELF, 9, 8, 10))
                EnemyType.MERCENARY -> enemyList.add(Enemy(EnemyType.MERCENARY, 8, 10, 5))
                EnemyType.TROLL -> enemyList.add(Enemy(EnemyType.TROLL, 8, 10, 5))
                else -> System.err.println("Something really bad happened.")
            }
        }
    }

    private fun Enemy(monster: EnemyType, i: Int, i1: Int, i2: Int): Enemy {
        TODO("Not yet implemented")
    }

    /**
     * Returns a List of Enemies.
     * @return      Returns the list of Enemies created.
     */
    fun getEnemyList(): List<Enemy> {
        return enemyList
    }

    init {
        enemyList = ArrayList()
    }
}