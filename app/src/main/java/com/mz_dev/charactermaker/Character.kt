package com.mz_dev.charactermaker

data class Character(
    private val head:String,
    private val torso:String,
    private val limbs:String
){
    fun toList(): List<String>{
        var stringList = mutableListOf<String>()
        if (head.isNotEmpty()) stringList.add("head made of $head ")
        if (torso.isNotEmpty()) stringList.add("trunk made of $torso ")
        if (limbs.isNotEmpty()) stringList.add("limbs made of $limbs ")
        return stringList
    }
}