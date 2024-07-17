package com.droidpawani.dev.adaptivelayouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.droidpawani.dev.adaptivelayouts.ui.PetStoreApplication
import com.droidpawani.dev.adaptivelayouts.ui.theme.AdaptiveLayoutsSampleTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            val appContainer = (application as PetsApplication).container
            val windowSizeClass = calculateWindowSizeClass(this)
            PetStoreApplication(
                appContainer = appContainer,
                windowSizeClass = windowSizeClass
            )
        }
    }
}
