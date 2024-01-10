package com.example.login_page_auth.ui.detail

import AddViewModel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.login_page_auth.PenyediaViewModel
import com.example.login_page_auth.navigation.DestinasiNavigasi

object DetailDestination : DestinasiNavigasi {
    override val route = "item_details"
    override val titleRes = "Detail Pet"
    const val petId = "itemId"
    val routeWithArgs = "$route/{$petId}"
}

@Composable
fun DetailScreen(
    navigateToItemEntry: () -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    addViewModel: AddViewModel = viewModel(factory = PenyediaViewModel.Factory),
){

}