package com.example.supercomposeapp.util

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.supercomposeapp.presentation.screen.FinalDestination
import com.example.supercomposeapp.presentation.screen.LoginScreen
import com.example.supercomposeapp.presentation.screen.RegistrationScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.LoginScreen.route
    ) {

        composable(ScreenRoutes.LoginScreen.route) {
            LoginScreen(
                onLoginSuccessNavigation = {
                    navController.navigate(ScreenRoutes.FinalDestination.route) {
                        popUpTo(0)
                    }
                },
                onNavigateToRegisterScreen = {
                    navController.navigate(ScreenRoutes.RegisterScreen.route) {
                        popUpTo(0)
                    }
                })
        }

        composable(ScreenRoutes.RegisterScreen.route) {
            RegistrationScreen(
                onRegistationSuccessNavigation = {
                    navController.navigate(ScreenRoutes.FinalDestination.route) {
                        popUpTo(0)
                    }
                },
                onNavigateToLoginScreen = {
                    navController.navigate(ScreenRoutes.LoginScreen.route) {
                        popUpTo(0)
                    }
                })
        }

        composable(ScreenRoutes.FinalDestination.route) {
            FinalDestination()
        }

    }
}

sealed class ScreenRoutes(val route: String) {
    object LoginScreen : ScreenRoutes("login_screen")
    object RegisterScreen : ScreenRoutes("register_screen")
    object FinalDestination : ScreenRoutes("final_destination")

}
