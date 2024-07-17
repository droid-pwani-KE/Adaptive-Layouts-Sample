package com.droidpawani.dev.adaptivelayouts.ui.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.droidpawani.dev.adaptivelayouts.data.AppContainer
import com.droidpawani.dev.adaptivelayouts.ui.orders.OrdersScreen
import com.droidpawani.dev.adaptivelayouts.ui.home.HomeScreen
import com.droidpawani.dev.adaptivelayouts.ui.home.HomeViewModel
import com.droidpawani.dev.adaptivelayouts.ui.messages.MessagesScreen

@Composable
fun MainNavHost(
    modifier : Modifier = Modifier,
    appContainer: AppContainer ,
    windowSizeClass: WindowSizeClass,
    navHostController: NavHostController,
    startDestination : String
){
    NavHost(
        navController = navHostController,
        startDestination = startDestination ,
        builder = {
            composable(NavConstants.home){ navBackStackEntry ->
                val homeViewModel: HomeViewModel = viewModel(
                    factory = HomeViewModel.provideFactory(
                       petsRepository = appContainer.postsRepository
                    )
                )
                HomeScreen(
                    viewModel = homeViewModel ,
                    isExpanded = windowSizeClass.widthSizeClass > WindowWidthSizeClass.Compact ,
                    onNavigateToPetDetails = {
                        //navigate to favourites screen
                    }
                )
            }
            composable(NavConstants.orders){ navBackStackEntry ->
                OrdersScreen()
            }
            composable(NavConstants.messages){ navBackStackEntry ->
                MessagesScreen()
            }
        }
    )
}

sealed class Screens(val route : String){
    data object Home : Screens(route = NavConstants.home)
    data object Orders : Screens(route = NavConstants.orders)
    data object Messages : Screens(route = NavConstants.messages)

}

object NavConstants {
    const val home = "Home"
    const val orders = "Orders"
    const val messages = "Messages"
}