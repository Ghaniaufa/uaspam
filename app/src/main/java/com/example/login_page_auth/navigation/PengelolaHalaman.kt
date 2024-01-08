package com.example.login_page_auth.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login_page_auth.IgViewModel
import com.example.login_page_auth.auth.HomeScreen
import com.example.login_page_auth.auth.LoginScreen
import com.example.login_page_auth.auth.MainScreen

sealed class DestinationScreen(val route: String) {
    object Main: DestinationScreen("main")
    object Login: DestinationScreen("login")
    object Sucess: DestinationScreen("sucess")

}

@Composable
fun AuthenticationApp(){
    val vm = hiltViewModel<IgViewModel>()
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = DestinationScreen.Main.route) {
        composable(DestinationScreen.Main.route){
            MainScreen(navController, vm )
        }
        composable(DestinationScreen.Login.route) {
            LoginScreen(navController, vm)
        }
        composable(DestinationScreen.Sucess.route) {
            HomeScreen(navController, vm)
        }
    }
}