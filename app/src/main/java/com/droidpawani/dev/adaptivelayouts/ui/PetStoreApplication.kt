package com.droidpawani.dev.adaptivelayouts.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.droidpawani.dev.adaptivelayouts.R
import com.droidpawani.dev.adaptivelayouts.data.AppContainer
import com.droidpawani.dev.adaptivelayouts.ui.navigation.MainNavHost
import com.droidpawani.dev.adaptivelayouts.ui.navigation.Screens
import com.droidpawani.dev.adaptivelayouts.ui.theme.AdaptiveLayoutsSampleTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetStoreApplication(
    appContainer: AppContainer,
    windowSizeClass: WindowSizeClass
) {
    val navItems = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            screens = Screens.Home
        ),
        BottomNavigationItem(
            title = "Orders",
            selectedIcon = Icons.Filled.List,
            unselectedIcon = Icons.Outlined.List,
            screens = Screens.Orders
        ),
        BottomNavigationItem(
            title = "Messages",
            selectedIcon = Icons.Filled.Email,
            unselectedIcon = Icons.Outlined.Email,
            screens = Screens.Messages
        )
    )

    AdaptiveLayoutsSampleTheme {

        var selectedItemIndex by rememberSaveable {
            mutableIntStateOf(0)
        }

        val navHostController = rememberNavController()

        Scaffold(
            topBar = {
                    if(windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact) {
                        TopAppBar(
                            modifier = Modifier.fillMaxWidth(),
                            title = {
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = "My Pet Store" ,
                                    textAlign = TextAlign.Center
                                )
                            }
                        )
                    }
            },
            bottomBar = {
                if (windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact) {
                    //show bottom nav bar here
                    NavigationBar {
                        navItems.forEachIndexed { index, item ->
                            NavigationBarItem(
                                selected = selectedItemIndex == index,
                                onClick = {
                                    selectedItemIndex = index
                                    //navigate here
                                    navHostController.navigate(
                                        item.screens.route
                                    )
                                },
                                icon = {
                                    Icon(
                                        imageVector = if (selectedItemIndex == index) item.selectedIcon else item.unselectedIcon,
                                        contentDescription = ""
                                    )
                                })
                        }
                    }
                }
            }/*,
            snackbarHost = {
                SnackbarHost(hostState = snackBarHostState)
            }*/
        ) { innerPadding ->
            if (windowSizeClass.widthSizeClass > WindowWidthSizeClass.Compact) {
                Row(
                    Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    //MainRailBar()
                    NavigationRail(
                        header = {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .padding(vertical = 12.dp)
                                    .clip(CircleShape)
                                    .background(color = MaterialTheme.colorScheme.primaryContainer),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    modifier = Modifier.size(30.dp),
                                    painter = painterResource(R.drawable.ic_pets),
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                        }
                    ) {
                        Spacer(Modifier.weight(1f))
                        navItems.forEachIndexed { index, item ->
                            NavigationRailItem(
                                selected = selectedItemIndex == index,
                                onClick = {
                                    selectedItemIndex = index
                                    navHostController.navigate(item.screens.route)
                                },
                                icon = {
                                    Icon(
                                        imageVector = if (selectedItemIndex == index) item.selectedIcon else item.unselectedIcon,
                                        contentDescription = ""
                                    )
                                },
                                label = { Text(item.title) },
                                alwaysShowLabel = false
                            )
                        }
                        Spacer(Modifier.weight(1f))
                    }
                    MainNavHost(
                        modifier = Modifier,
                        windowSizeClass = windowSizeClass,
                        navHostController = navHostController,
                        startDestination = Screens.Home.route ,
                        appContainer = appContainer
                    )
                }
            } else {
                MainNavHost(
                    modifier = Modifier.padding(innerPadding),
                    windowSizeClass = windowSizeClass,
                    navHostController = navHostController,
                    startDestination = Screens.Home.route ,
                    appContainer = appContainer
                )
            }
        }
    }
}

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val screens: Screens
)