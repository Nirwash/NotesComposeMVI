package com.example.notesmvi.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.notesmvi.presentation.screen.main.MainScreen


sealed class Screens(val route: String) {
    object MainScreen : Screens(route = "main_screen")
}

@Composable
fun SetupNavHost(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screens.MainScreen.route) {
        composable(Screens.MainScreen.route) {
            MainScreen(navHostController = navHostController)
        }
    }
}