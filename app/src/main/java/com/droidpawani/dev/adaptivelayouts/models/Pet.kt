package com.droidpawani.dev.adaptivelayouts.models

data class Pet(
    val id : String = "",
    val description : String = "" ,
    val image : String = "" ,
    val price : Double = 0.0 ,
    val age : Int = 0 ,
    val size : String = "",
    val attributes : Map<String,String> = mapOf()
)

