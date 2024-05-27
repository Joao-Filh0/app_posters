package com.example.appposters.ui.pages.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.appposters.core.veiw_model.PostsViewModel
import com.example.appposters.ui.pages.home.components.CardTitleComponent
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(viewModel: PostsViewModel, navController: NavHostController) {
    val scope = rememberCoroutineScope()
    val data by viewModel.posts.observeAsState(emptyList())
    LaunchedEffect(Unit) {
        viewModel.fetchPosts()
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {

                    Text("Home")
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
                Text(text = "Loading...")
            } else {
                LazyColumn {
                    items(data.size) { post ->
                        CardTitleComponent(post = data[post]) {
                            scope.launch {
                                navController.navigate("details")
                            }
                        }

                    }
                }
            }
        }
    }
}
