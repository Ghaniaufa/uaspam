package com.example.login_page_auth.ui.detail

import com.example.login_page_auth.navigation.DestinasiNavigasi

object DetailDestination : DestinasiNavigasi {
    override val route = "item_details"
    override val titleRes = "Detail Pet"
    const val petId = "itemId"
    val routeWithArgs = "$route/{$petId}"
}