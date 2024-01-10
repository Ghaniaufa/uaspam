package com.example.login_page_auth.navigation

import AddScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.login_page_auth.ui.auth.MainScreen
import com.example.login_page_auth.ui.detail.DetailDestination
import com.example.login_page_auth.ui.detail.DetailScreen
import com.example.login_page_auth.ui.home.HomeScreen
import com.example.login_page_auth.ui.login.IgViewModel
import com.example.login_page_auth.ui.login.LoginScreen
import com.example.login_page_auth.ui.product.ProductScreen
import com.google.firebase.auth.FirebaseAuth

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
            ProductScreen(navigateToItemEntry = { /*TODO*/ }, navigateBack = {navController.popBackStack()})
        }
    }
}