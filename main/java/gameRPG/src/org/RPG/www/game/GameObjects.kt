package org.academiadecodigo.www.game

import android.os.Parcel
import android.os.Parcelable

abstract class GameObjects()  {

    fun takeHit(attackPower: Int) {}
    fun getName(): Any {
        TODO("Not yet implemented")
    }


    abstract fun getBonus(): Byte

}
