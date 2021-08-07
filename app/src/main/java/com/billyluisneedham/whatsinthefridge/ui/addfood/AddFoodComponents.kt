package com.billyluisneedham.whatsinthefridge.ui.addfood

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.billyluisneedham.whatsinthefridge.R
import com.billyluisneedham.whatsinthefridge.ui.theme.WhatsInTheFridgeTheme

@Composable
fun AddFoodScreen() {
    Surface {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.add_food))
                    }
                )
            }
        ) { innerPadding ->
            AddFoodContent(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun AddFoodContent(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.add_food)
        )
    }
}

@Preview
@Composable
fun AddFoodScreenPreview() {
    WhatsInTheFridgeTheme {
        AddFoodScreen()
    }
}
