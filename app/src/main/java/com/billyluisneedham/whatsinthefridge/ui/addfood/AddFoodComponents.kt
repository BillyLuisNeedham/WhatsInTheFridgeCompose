package com.billyluisneedham.whatsinthefridge.ui.addfood

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.billyluisneedham.whatsinthefridge.R
import com.billyluisneedham.whatsinthefridge.ui.theme.WhatsInTheFridgeTheme

@Composable
fun AddFoodScreen(onBack: () -> Unit) {
    val smallPadding = dimensionResource(id = R.dimen.padding_small)

    Surface {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.add_food))
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = stringResource(id = R.string.back_content_description)
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            AddFoodContent(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(smallPadding)
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
        AddFoodScreen(onBack = {})
    }
}
