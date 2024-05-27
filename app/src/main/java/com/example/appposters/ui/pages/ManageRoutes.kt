package com.example.appposters.ui.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appposters.core.models.PostModel
import com.example.appposters.ui.pages.details.DetailsPage
import com.example.appposters.ui.pages.home.HomePage
import com.example.appposters.utils.extensions.setParams
import com.example.appposters.utils.routes.Routes

val LocalNavController = compositionLocalOf<NavHostController> {
    error("No LocalNavController provided")
}


@Composable
fun ManageRoutes() {

    val navController = rememberNavController()
    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(navController = navController, startDestination = Routes.HOME.name) {
            composable(Routes.HOME.name) { HomePage() }
            composable(
                Routes.DETAILS.setParams("{data}"),
            ) { entry ->
                val data = entry.arguments?.getString("data") ?: ""
                DetailsPage(post = PostModel.fromJson(data))


            }
        }
    }
}