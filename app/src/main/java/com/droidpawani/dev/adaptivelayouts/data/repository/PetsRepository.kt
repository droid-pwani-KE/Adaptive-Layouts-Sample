package com.droidpawani.dev.adaptivelayouts.data.repository

import com.droidpawani.dev.adaptivelayouts.models.Pet
import com.droidpawani.dev.adaptivelayouts.models.PetsFilter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface PetsRepository {

    fun getAllPets(filter : PetsFilter?) : Flow<List<Pet>>
    suspend fun toggleFavouritePet(pet : Pet)

    fun getAllFavouritePets() : Flow<Set<String>>

    fun getAllColors() : Result<List<String>>

}