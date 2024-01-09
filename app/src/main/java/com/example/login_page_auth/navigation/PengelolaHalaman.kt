package com.example.login_page_auth.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login_page_auth.auth.MainScreen
import com.example.login_page_auth.home.HomeScreen
import com.example.login_page_auth.login.IgViewModel
import com.example.login_page_auth.login.LoginScreen

sealed class DestinationScreen(val route: String) {
    object Main: DestinationScreen("main")
    object Login: DestinationScreen("login")
    object Home: DestinationScreen("home")

}
@Composable
fun PengelolaHalaman (navController: NavHostController = rememberNavController()){
    val viewModel = hiltViewModel<IgViewModel>()
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = DestinationScreen.Main.route){
        composable(DestinationScreen.Main.route){
            MainScreen(navController, viewModel )
        }
        composable(DestinationScreen.Login.route){
            LoginScreen(navController , viewModel )
        }
        composable(DestinationScreen.Home.route){
            HomeScreen(navController, viewModel)
        }
    }
}
