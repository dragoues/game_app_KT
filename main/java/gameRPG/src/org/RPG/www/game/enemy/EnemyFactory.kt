package org.academiadecodigo.www.game.enemy

import com.example.myapplicationgamekt.enemy
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
                EnemyType.MONSTER -> enemyList.also {  }
                EnemyType.DRAGON -> enemyList.also {  }
                EnemyType.DWARF -> enemyList.also {  }
                EnemyType.ELF -> enemyList.also {  }
                EnemyType.MERCENARY -> enemyList.also {  }
                EnemyType.TROLL -> enemyList.also {  }
                else -> System.err.println("Something really bad happened.")
            }
        }
    }

    /**
     * Returns a List of Enemies.
     * @return      Returns the list of Enemies created.
     */
    fun getEnemyList(): List<Enemy> {
        return enemyList
    }

    init {
        enemyList = ArrayList<Enemy>()
    }
}

class Enemy(monster: enemy.EnemyType, i: Int, i1: Int, i2: Int) {

}
