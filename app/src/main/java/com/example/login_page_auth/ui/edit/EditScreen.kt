package com.example.login_page_auth.ui.edit

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.login_page_auth.PenyediaViewModel
import com.example.login_page_auth.navigation.DestinasiNavigasi

object EditDestination : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = "Edit Pet"
    const val petId = "itemtId"
    val routeWithArgs = "${EditDestination.route}/{$petId}"
}

@Composable
fun EditScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditViewModel = viewModel(factory = PenyediaViewModel.Factory )
){

}