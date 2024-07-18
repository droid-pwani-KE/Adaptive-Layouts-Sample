package com.droidpawani.dev.adaptivelayouts.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.droidpawani.dev.adaptivelayouts.R
import com.droidpawani.dev.adaptivelayouts.ui.BottomNavigationItem

@Composable
fun MainRailBar(
    navItems : List<BottomNavigationItem> ,
    selectedItemIndex : Int ,
    navHostController: NavHostController ,
    onNavItemSelected : (Int) -> Unit
){
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
                    onNavItemSelected(index)
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
}