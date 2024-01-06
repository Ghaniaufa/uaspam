package com.example.login_page_auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login_page_auth.auth.LoginScreen
import com.example.login_page_auth.auth.MainScreen
import com.example.login_page_auth.auth.SuccessScreen
import com.example.login_page_auth.ui.theme.Login_page_authTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Login_page_authTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AuthenticationApp()
                }
            }
        }
    }
}

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
            SuccessScreen(navController, vm)
        }
    }
}