package com.droidpawani.dev.adaptivelayouts.ui.orders

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.droidpawani.dev.adaptivelayouts.ui.theme.AdaptiveLayoutsSampleTheme

@Composable
fun OrdersScreen(){
    OrdersStatelessScreen()
}

@Composable
private fun OrdersStatelessScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Orders destination",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun ScreenPreview(){
    AdaptiveLayoutsSampleTheme{
        OrdersStatelessScreen()
    }
}