package com.example.appposters.ui.pages

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
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

fun scaleIntoContainer(
): EnterTransition {
    return scaleIn(
        animationSpec = tween(220, delayMillis = 90),
        initialScale =1.1f
    ) + fadeIn(animationSpec = tween(220, delayMillis = 90))
}

fun scaleOutOfContainer(
): ExitTransition {
    return scaleOut(
        animationSpec = tween(
            durationMillis = 220,
            delayMillis = 90
        ), targetScale = 1.1f
    ) + fadeOut(tween(delayMillis = 90))
}

@Composable
fun ManageRoutes() {

    val navController = rememberNavController()
    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(navController = navController, startDestination = Routes.HOME.name) {
            composable(Routes.HOME.name, exitTransition = {
                scaleOutOfContainer()
            }, enterTransition = {
                scaleIntoContainer()
            }) { HomePage() }
            composable(
                Routes.DETAILS.setParams("{data}"),
                exitTransition = {
                    scaleOutOfContainer()
                }, enterTransition = {
                    scaleIntoContainer()
                }
            ) { entry ->
                val data = entry.arguments?.getString("data") ?: ""
                DetailsPage(post = PostModel.fromJson(data))


            }
        }
    }
}