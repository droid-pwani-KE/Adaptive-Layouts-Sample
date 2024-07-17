package com.droidpawani.dev.adaptivelayouts.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.droidpawani.dev.adaptivelayouts.models.Pet
import com.droidpawani.dev.adaptivelayouts.ui.theme.AdaptiveLayoutsSampleTheme

@Composable
fun HomeScreen(
    isExpanded: Boolean = true,
    viewModel: HomeViewModel,
    onNavigateToPetDetails: (Pet) -> Unit
) {
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
        Text(
            text = "Home destination",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AdaptiveLayoutsSampleTheme {
        StatelessHomeScreen()
    }
}