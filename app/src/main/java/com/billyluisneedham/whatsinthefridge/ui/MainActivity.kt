package com.billyluisneedham.whatsinthefridge.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.billyluisneedham.whatsinthefridge.ui.MainViewModel
import com.billyluisneedham.whatsinthefridge.ui.WhatsInTheFridgeApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhatsInTheFridgeApp(
                onBack = { onBackPressed() },
                mainViewModel = mainViewModel
            )
        }
    }
}
