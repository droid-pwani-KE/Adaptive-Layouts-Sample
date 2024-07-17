package com.droidpawani.dev.adaptivelayouts.ui.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.droidpawani.dev.adaptivelayouts.data.repository.PetsRepository
import com.droidpawani.dev.adaptivelayouts.models.Pet
import com.droidpawani.dev.adaptivelayouts.models.PetsFilter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val petsRepository: PetsRepository ,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _homeUiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    val homeUiState get() = _homeUiState.asStateFlow()

    fun getPetsList(filter : PetsFilter?) {
        viewModelScope.launch {
            val favouritePets = petsRepository.getAllFavouritePets()
            petsRepository.getAllPets(filter)
                .combine( flow = favouritePets){ pets , favouriteList ->
                    pets.map { pet ->
                        if (favouriteList.contains(pet.id)) {
                            pet.copy(isFavourite = true)
                        } else {
                            pet
                        }
                    }
                }.collect { newPetList ->
                    _homeUiState.update {
                        it.copy(
                            isLoading = false ,
                            petsList = newPetList
                        )
                    }
                }
        }
    }


    companion object {
        fun provideFactory(
            petsRepository: PetsRepository ,
            savedStateHandle: SavedStateHandle
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return HomeViewModel(petsRepository , savedStateHandle) as T
            }
        }
    }

    data class HomeUiState(
        val isLoading: Boolean = false,
        val petsList: List<Pet> = listOf(Pet())
    )

}