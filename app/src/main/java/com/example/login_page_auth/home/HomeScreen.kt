package com.example.login_page_auth.home

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.login_page_auth.login.IgViewModel

@Composable
fun HomeScreen(
   navigateToItemEntry: () -> Unit,
   modifier: Modifier = Modifier,
   onDetailClick: (String) -> Unit = {},
   viewModel: HomeViewModel = viewModel(factory = PenyediaViewModel.Factory)
){

}