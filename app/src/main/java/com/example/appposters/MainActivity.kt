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
import com.example.appposters.core.models.PostModel
import com.example.appposters.ui.pages.details.DetailsPage
import com.example.appposters.ui.pages.home.HomePage
import com.example.appposters.ui.theme.AppPostersTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppPostersTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Main()
                }
            }
        }
    }
}

@Composable
fun Main() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomePage(navController = navController) }
        composable(
            "details/{userId}/{id}/{title}/{body}",
        ) { entry ->
            val arguments = entry.arguments
            val post: PostModel =
                PostModel(
                    title = arguments?.getString("title") ?: "",
                    body = arguments?.getString("body") ?: "",
                    userId = (arguments?.getString("userId") ?: "").toInt(),
                    id = (arguments?.getString("id") ?: "").toInt(),
                )
            DetailsPage(post = post) {
                navController.popBackStack()
            }


        }
    }
}
