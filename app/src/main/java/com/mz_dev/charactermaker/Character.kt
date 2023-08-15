package com.mz_dev.charactermaker

data class Character(
    private val head:String,
    private val torso:String,
    private val limbs:String
){
    fun toList(): List<String>{
        var stringList = mutableListOf<String>()
        if (head.isNotEmpty()) stringList.add("$head head ")
        if (torso.isNotEmpty()) stringList.add("$torso torso ")
        if (limbs.isNotEmpty()) stringList.add("$limbs limbs ")
        return stringList
    }
}