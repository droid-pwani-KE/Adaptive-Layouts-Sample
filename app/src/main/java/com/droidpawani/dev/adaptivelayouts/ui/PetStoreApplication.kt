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
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScope
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
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
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.droidpawani.dev.adaptivelayouts.R
import com.droidpawani.dev.adaptivelayouts.data.AppContainer
import com.droidpawani.dev.adaptivelayouts.ui.components.MainRailBar
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

        val navHostController = rememberNavController()
        val navBackStackEntry by navHostController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                if (windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact) {
                    TopAppBar(
                        modifier = Modifier.fillMaxWidth(),
                        title = {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "My Pet Store",
                                textAlign = TextAlign.Center
                            )
                        }
                    )
                }
            }
        ) { innerPadding ->

            NavigationSuiteScaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                navigationSuiteItems = navigationSuiteItems(
                    navigationItems = navItems,
                    currentDestination = currentDestination,
                    navHost = navHostController
                ),
                layoutType = if (windowSizeClass.widthSizeClass > WindowWidthSizeClass.Compact) {
                        NavigationSuiteType.NavigationRail
                }else if (windowSizeClass.widthSizeClass == WindowWidthSizeClass.Expanded){
                    NavigationSuiteType.NavigationDrawer
                }else{
                    NavigationSuiteType.NavigationBar
                }
            ) {
                MainNavHost(
                    modifier = Modifier.padding(innerPadding),
                    windowSizeClass = windowSizeClass,
                    navHostController = navHostController,
                    startDestination = Screens.Home.route,
                    appContainer = appContainer
                )
            }
        }
    }
}

@Composable
private fun navigationSuiteItems(
    navigationItems: List<BottomNavigationItem>,
    currentDestination: NavDestination?,
    navHost: NavHostController
): NavigationSuiteScope.() -> Unit = {

    navigationItems.forEachIndexed { index, item ->
        item(
            selected = currentDestination?.hierarchy?.any { it.route == item.screens.route } == true,
            onClick = {
                navigateWithBackStackHandling(item.screens.route, navHost)
            },
            label = { Text(item.title) },
            icon = {
                Icon(
                    imageVector = item.selectedIcon,
                    contentDescription = ""
                )
            },
        )
    }
}

fun navigateWithBackStackHandling(route: String, navHost: NavHostController) {
    navHost.navigate(route) {
        popUpTo(navHost.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val screens: Screens
)