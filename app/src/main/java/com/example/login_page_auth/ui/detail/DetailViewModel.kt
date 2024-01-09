package com.example.login_page_auth.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.login_page_auth.repositori.PetRepositori

class DetailViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositori: PetRepositori

) : ViewModel(){

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val petId: String = checkNotNull(savedStateHandle[DetailAddDestination])
}
