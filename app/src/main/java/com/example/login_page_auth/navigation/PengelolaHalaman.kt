package com.example.login_page_auth.navigation

import AddScreen
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login_page_auth.ui.auth.MainScreen
import com.example.login_page_auth.ui.home.HomeScreen
import com.example.login_page_auth.ui.login.IgViewModel
import com.example.login_page_auth.ui.login.LoginScreen

sealed class DestinationScreen(val route: String) {
    object Main: DestinationScreen("main")
    object Login: DestinationScreen("login")
    object Home: DestinationScreen("home")
    object AddData: DestinationScreen("add")

    object AllData: DestinationScreen("all")
    object Product: DestinationScreen("product")

    

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
            HomeScreen(navController = {navController.popBackStack()}, viewModel)
        }
        composable(DestinationScreen.AddData.route){
            AddScreen(navigateBack = {navController.popBackStack()})
        }
    }
}
