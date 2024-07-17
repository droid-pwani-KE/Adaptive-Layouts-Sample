package com.droidpawani.dev.adaptivelayouts.models

data class Pet(
    val id : String = "",
    val name : String = "",
    val breed : String = "",
    val description : String = "",
    val image : String = "",
    val price : Double = 0.0,
    val age : Int = 0,
    val weight : Double = 0.0,
    val color : String = "" ,
    val healthRisk : String = "" ,
    val temperament : List<String> = listOf() ,
    val isFavourite : Boolean = false
)

