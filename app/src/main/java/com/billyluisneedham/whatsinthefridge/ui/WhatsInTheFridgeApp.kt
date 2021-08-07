package com.billyluisneedham.whatsinthefridge.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.billyluisneedham.whatsinthefridge.ui.theme.WhatsInTheFridgeTheme

@Composable
fun WhatsInTheFridgeApp() {
    WhatsInTheFridgeTheme {
        val navController = rememberNavController()
        Surface {
            Scaffold { innerPadding ->
                WhatsInTheFridgeNavHost(
                    navController = navController,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WhatsInTheFridgeApp()
}