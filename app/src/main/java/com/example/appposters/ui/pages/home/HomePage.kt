package com.example.appposters.ui.pages.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appposters.core.veiw_model.PostsViewModel
import com.example.appposters.ui.pages.LocalNavController
import com.example.appposters.ui.pages.home.components.CardTitleComponent
import com.example.appposters.ui.theme.AppPostersTheme
import com.example.appposters.utils.extensions.addClassArguments
import com.example.appposters.utils.routes.Routes
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage() {
    val viewModel: PostsViewModel = viewModel()
    val scope = rememberCoroutineScope()
    val data by viewModel.posts.collectAsState()

    val navController = LocalNavController.current
    LaunchedEffect(Unit) {
        viewModel.fetchPosts()
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {

                    Text(
                        text = "Home Compose", modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                    )
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.background,
                ),
            )
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            if (data.isEmpty()) {
                Box(
                    modifier =
                    Modifier.fillMaxWidth()
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }

            } else {
                LazyColumn {
                    items(data.size) { index ->
                        val post = data[index]
                        CardTitleComponent(post = post) {
                            scope.launch {
                                navController.navigate(Routes.DETAILS.addClassArguments(post))
                            }
                        }

                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppPostersTheme {

    }
}