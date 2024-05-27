package com.example.appposters.ui.pages.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsPage() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Page Details", modifier = Modifier.fillMaxWidth())
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.background
                )

            )
        }
    ) {
        Column(modifier = Modifier.padding(it)) {

        }
    }
}