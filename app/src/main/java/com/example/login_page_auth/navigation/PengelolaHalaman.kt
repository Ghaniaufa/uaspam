package com.example.login_page_auth.navigation

import AddScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.viewModelFactory
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

sealed class DestinationScreen(val route: String) {
    object Main: DestinationScreen("main")
    object Login: DestinationScreen("login")
    object Home: DestinationScreen("home")
    object AddData: DestinationScreen("add")

    object AllData: DestinationScreen("all")
    object Product: DestinationScreen("product")

    

}
@Composable
fun PengelolaHalaman() {
    val viewModel = hiltViewModel<IgViewModel>()
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = DestinationScreen.Main.route,
        modifier = Modifier
    ) {
        composable(DestinationScreen.Main.route) {
            MainScreen(navController, viewModel)
        }
        composable(DestinationScreen.Login.route) {
            LoginScreen(navController, viewModel)
        }
        composable(route = DetailDestination.routeWithArgs,
            arguments = listOf(navArgument(DetailDestination.petId){
                type = NavType.StringType
            })
        ){ backStackEntry ->
            val petId = backStackEntry.arguments?.getString(DetailDestination.petId)
            petId?.let {
                DetailScreen(
                    navigateToItemEntry = { navController.navigate("${DetailDestination.route}/$petId")},
                    navigateBack = { navController.popBackStack()})
            }

        }
        composable(DestinationScreen.AddData.route) {
            AddScreen(navigateBack = { navController.popBackStack() })
        }
    }
}
