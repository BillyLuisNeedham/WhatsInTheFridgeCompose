package com.billyluisneedham.whatsinthefridge.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.billyluisneedham.whatsinthefridge.ui.theme.WhatsInTheFridgeTheme

//TODO ADD VIEW MODEL, NEED TO FIGURE OUT
// HOW TO COME COLLECT A FLOW AND MAP TO UI
// SEE https://developer.android.com/jetpack/compose/state
@Composable
fun WhatsInTheFridgeApp(
    onBack: () -> Unit,
    mainViewModel: MainViewModel
) {
    WhatsInTheFridgeTheme {
        val navController = rememberNavController()
        Surface {
            Scaffold { innerPadding ->
                WhatsInTheFridgeNavHost(
                    navController = navController,
                    modifier = Modifier.padding(innerPadding),
                    onBack = onBack,
                    mainViewModel = mainViewModel
                )
            }
        }
    }
}

