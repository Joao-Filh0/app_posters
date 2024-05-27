package com.example.appposters.ui.pages.details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.appposters.core.models.PostModel
import com.example.appposters.ui.theme.AppPostersTheme
import com.example.appposters.ui.pages.LocalNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsPage(post: PostModel) {

    val navController = LocalNavController.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Page Details", modifier = Modifier.fillMaxWidth())
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.background
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.background
                        )
                    }
                }

            )
        }
    ) {
        val scrollState = rememberScrollState()
        Column(modifier = Modifier.padding(it).verticalScroll(scrollState)) {

            Box(modifier = Modifier.padding(20.dp)) {
                AsyncImage(
                    model = post.url,
                    contentDescription = "Example Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp).clip(RoundedCornerShape(10.dp))
                        .border(
                            BorderStroke(2.dp, Color.Black),
                            shape = RoundedCornerShape(10.dp)
                        ),
                    contentScale = ContentScale.Crop
                )
            }
            _CustomRow(title = "ID", description = post.id.toString())
            _CustomRow(title = "USER-ID", description = "${post.userId}")
            _CustomRow(title = "TITLE", description = post.title)
            _CustomRow(title = "BODY", description = post.body)


        }
    }
}


@Composable
private fun _CustomRow(title: String, description: String) {
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Text(text = "$title :", style = TextStyle(fontWeight = FontWeight.Bold))
        Box(modifier = Modifier.size(10.dp))
        Text(text = description, style = TextStyle(fontWeight = FontWeight.Normal))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppPostersTheme {
        DetailsPage(
            post = PostModel(
                1,
                id = 1,
                title = "MY FAKE TITLE",
                body = "MY BODY FAKE AHAHAHAHAHAHAAHAHAH!!!"
            )
        )
        // HomePage("Android", viewModel = viewModel())
    }
}