package com.billyluisneedham.whatsinthefridge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.billyluisneedham.whatsinthefridge.ui.WhatsInTheFridgeApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhatsInTheFridgeApp(onBack = { onBackPressed() })
        }
    }
}

