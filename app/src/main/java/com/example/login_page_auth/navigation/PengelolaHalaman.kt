package com.example.login_page_auth.navigation

import AddScreen
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login_page_auth.ui.auth.MainScreen
import com.example.login_page_auth.ui.list.DetailScreen
import com.example.login_page_auth.ui.edit.EditScreen
import com.example.login_page_auth.ui.home.HomeScreen
import com.example.login_page_auth.ui.login.IgViewModel
import com.example.login_page_auth.ui.login.LoginScreen
import com.example.login_page_auth.ui.product.ProductScreen

sealed class DestinationScreen(val route: String) {
    object Main: DestinationScreen("main")
    object Login: DestinationScreen("login")
    object Home: DestinationScreen("home")
    object AddData: DestinationScreen("add")

    object AllData: DestinationScreen("all")
    object Product: DestinationScreen("product")



}
@Composable
fun PengelolaHalaman (navController: NavController = rememberNavController()){
    val viewModel = hiltViewModel<IgViewModel>()


    NavHost(
        navController = navController as NavHostController,
        startDestination = "MainScreen"
    ) {
        composable("MainScreen") {
            MainScreen(navController, viewModel)
        }
        composable("LoginPage") {
           LoginScreen(navController , viewModel )
        }
        composable("HomeScreen") {
            HomeScreen(navController)
        }
        composable("PetHotelScreen"){
            AddScreen(
                navigateBack = {navController.popBackStack()})
        }
        composable("AllDataPet"){
            DetailScreen(
                navigateBack = {navController.popBackStack()},
                navigateToItemEntry = { /*TODO*/ },
                navController = navController
            )
        }
        composable("Product"){
            ProductScreen(
                navigateToItemEntry = { /*TODO*/ },
                navigateBack = {navController.popBackStack()})
        }
        composable("EditScreen"){
           EditScreen(
               navigateBack = {navController.popBackStack()}, navController = navController )

        }
    }
}