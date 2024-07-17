package com.droidpawani.dev.adaptivelayouts.models

data class PetsFilter(
    val color : String? ,
    val priceRange : DoubleRange? ,
    val age : IntRange?,
    val weightRange : DoubleRange?
) {
    data class DoubleRange(
        val start : Double ,
        val end : Double
    )
    data class IntRange(
        val start: Int ,
        val end : Int
    )
}


