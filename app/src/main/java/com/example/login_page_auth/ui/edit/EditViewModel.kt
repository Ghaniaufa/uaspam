package com.example.login_page_auth.ui.edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.login_page_auth.AddUIState
import com.example.login_page_auth.repositori.PetRepositori

class EditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositori: PetRepositori
) : ViewModel() {

    var petUiState by   mutableStateOf(AddUIState())
        private set

    private val petId: String = checkNotNull(savedStateHandle[EditDestination.petId])


}