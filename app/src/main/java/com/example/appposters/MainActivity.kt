package com.example.appposters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appposters.core.veiw_model.PostsViewModel
import com.example.appposters.ui.pages.details.DetailsPage
import com.example.appposters.ui.pages.home.HomePage
import com.example.appposters.ui.theme.AppPostersTheme

class MainActivity : ComponentActivity() {
    private val viewModel: PostsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppPostersTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Main(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun Main(viewModel: PostsViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomePage(navController = navController, viewModel = viewModel) }
        composable("details") {  DetailsPage() }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppPostersTheme {
       // HomePage("Android", viewModel = viewModel())
    }
}