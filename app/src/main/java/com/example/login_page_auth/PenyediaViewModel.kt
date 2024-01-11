package com.example.login_page_auth

import AddViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.login_page_auth.ui.list.DetailViewModel
import com.example.login_page_auth.ui.edit.EditViewModel

fun CreationExtras.aplikasiPet(): FirebaseAuthenticationApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as FirebaseAuthenticationApp)

object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            AddViewModel(aplikasiPet().container.petRepositori)
        }
        initializer {
            DetailViewModel(aplikasiPet().container.petRepositori)
        }
        initializer {
            EditViewModel(createSavedStateHandle(),
                aplikasiPet().container.petRepositori)
        }

    }


}