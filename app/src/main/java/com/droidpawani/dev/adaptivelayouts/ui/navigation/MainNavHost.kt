package com.droidpawani.dev.adaptivelayouts.ui.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MainNavHost(
    modifier : Modifier = Modifier,
    windowSizeClass: WindowSizeClass,
    navHostController: NavHostController,
    startDestination : String
){
    NavHost(
        navController = navHostController,
        startDestination = startDestination ,
        builder = {
            composable(NavConstants.home){

            }
            composable(NavConstants.orders){

            }
            composable(NavConstants.messages){

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