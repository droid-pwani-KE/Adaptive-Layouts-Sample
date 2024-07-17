package com.droidpawani.dev.adaptivelayouts.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droidpawani.dev.adaptivelayouts.models.Pet
import com.droidpawani.dev.adaptivelayouts.ui.components.PetCardLandScape
import com.droidpawani.dev.adaptivelayouts.ui.components.PetsCardPortrait
import com.droidpawani.dev.adaptivelayouts.ui.theme.AdaptiveLayoutsSampleTheme

@Composable
fun HomeScreen(
    isExpanded: Boolean = true,
    viewModel: HomeViewModel,
    onNavigateToPetDetails: (Pet) -> Unit
) {
    LaunchedEffect(key1 = true){
        viewModel.getPetsList(null)
    }
    val state = viewModel.homeUiState.collectAsState()
    StatelessHomeScreen(
        uiState = state.value,
        isExpanded = isExpanded,
        onToggleFavourite = {
            viewModel.toggleFavourite(it)
        },
        onNavigateToPetDetails = {
            onNavigateToPetDetails(it)
        }
    )

}


@Composable
fun StatelessHomeScreen(
    isExpanded: Boolean = false,
    uiState: HomeViewModel.HomeUiState = HomeViewModel.HomeUiState(),
    onToggleFavourite: (Pet) -> Unit = {},
    onNavigateToPetDetails: (Pet) -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val gridCells = if(isExpanded)GridCells.Fixed(2) else GridCells.Fixed(3)
        LazyVerticalGrid(
            columns = gridCells ,
            verticalArrangement = Arrangement.spacedBy(8.dp) ,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){

            items(items = uiState.petsList){ pet ->
                if (isExpanded){
                    PetCardLandScape(
                        pet = pet ,
                        onFavourite = {
                            onToggleFavourite(pet)
                        } ,
                        onPetSelected = {

                        }
                    )
                }else{
                    PetsCardPortrait(
                        pet = pet ,
                        onFavourite = {
                            onToggleFavourite(pet)
                        } ,
                        onPetSelected = {

                        }
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AdaptiveLayoutsSampleTheme {
        StatelessHomeScreen()
    }
}