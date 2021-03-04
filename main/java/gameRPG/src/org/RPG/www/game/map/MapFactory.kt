package org.academiadecodigo.www.game.map

import java.util.*

class MapFactory(
    enemyFactory: org.academiadecodigo.www.game.enemy.EnemyFactory,
    itemFactory: org.academiadecodigo.www.game.item.ItemFactory
) {
    private val itemFactory: org.academiadecodigo.www.game.item.ItemFactory
    private val enemyFactory: org.academiadecodigo.www.game.enemy.EnemyFactory

    /**
     * Return a new Map with all the specifications.
     * @param mapZones          A Map Zone.
     * @param enemyHash         A map of Type of Enemies and Quantities.
     * @param itemHash          A map of Type of Items and Quantities
     * @return                  Returns a new Map.
     */
    fun createMap(
        mapZones: MapZones,
        enemyHash: HashMap<org.academiadecodigo.www.game.enemy.EnemyType, Int>,
        itemHash: HashMap<org.academiadecodigo.www.game.item.ItemType, Int>
    ) {
        for ((enemyType, value) in enemyHash) {
            enemyFactory.createEnemy(enemyType, value)
        }
        for ((itemType, value) in itemHash) {
            itemFactory.createItem(itemType, value)
        }

    }

    init {
        this.enemyFactory = enemyFactory
        this.itemFactory = itemFactory
    }
}