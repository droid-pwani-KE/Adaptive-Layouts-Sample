package com.droidpawani.dev.adaptivelayouts.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.droidpawani.dev.adaptivelayouts.data.AppContainer
import com.droidpawani.dev.adaptivelayouts.ui.navigation.MainNavHost
import com.droidpawani.dev.adaptivelayouts.ui.navigation.Screens
import com.droidpawani.dev.adaptivelayouts.ui.theme.AdaptiveLayoutsSampleTheme

@Composable
fun PetStoreApplication(
    snackBarHostState: SnackbarHostState,
    appContainer: AppContainer,
    windowSizeClass : WindowSizeClass
){

    AdaptiveLayoutsSampleTheme {
        val navItems = listOf(
            BottomNavigationItem(
                title = "Home" ,
                selectedIcon = Icons.Filled.Home ,
                unselectedIcon = Icons.Outlined.Home ,
                screens = Screens.Home
            ) ,
            BottomNavigationItem(
                title = "Orders" ,
                selectedIcon = Icons.Filled.List ,
                unselectedIcon = Icons.Outlined.List ,
                screens = Screens.Orders
            ) ,
            BottomNavigationItem(
                title = "Messages" ,
                selectedIcon = Icons.Filled.Email ,
                unselectedIcon = Icons.Outlined.Email ,
                screens = Screens.Messages
            )
        )
        var selectedItemIndex by rememberSaveable {
            mutableIntStateOf(0)
        }
        Scaffold(
            bottomBar = {
                if (windowSizeClass.widthSizeClass  == WindowWidthSizeClass.Compact){
                    //show bottom nav bar here
                    NavigationBar {
                        navItems.forEachIndexed { index, item ->
                            NavigationBarItem(
                                selected = selectedItemIndex == index ,
                                onClick = {
                                          selectedItemIndex = index
                                            //navigate here
                                },
                                icon = {
                                    Icon(
                                       imageVector = if(selectedItemIndex == index) item.selectedIcon else item.unselectedIcon ,
                                        contentDescription = ""
                                    )
                                })
                        }
                    }
                }
            } ,
            snackbarHost = {
                SnackbarHost(hostState = snackBarHostState)
            }
        ) { innerPadding ->
            if (windowSizeClass.widthSizeClass > WindowWidthSizeClass.Compact) {
                Row(
                    Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    //MainRailBar()
                   /* MainNavHost(
                        modifier = Modifier,
                        windowSizeClass = windowSizeClass ,
                        navHostController =
                    )*/
                }
            } else {
                /*MainNavHost(
                    modifier = Modifier.padding(innerPadding),
                    windowSizeClass = windowSizeClass ,
                    navHostController =
                )*/
            }
        }
    }
}

data class BottomNavigationItem(
    val title :String ,
    val selectedIcon : ImageVector ,
    val unselectedIcon : ImageVector ,
    val screens: Screens
)