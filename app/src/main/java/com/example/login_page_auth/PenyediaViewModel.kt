package com.example.login_page_auth

import AddViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.login_page_auth.ui.home.HomeViewModel
import com.example.login_page_auth.ui.login.IgViewModel

fun CreationExtras.aplikasiPet(): FirebaseAuthenticationApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as FirebaseAuthenticationApp)

object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            HomeViewModel(aplikasiPet().container.petRepositori)
        }
        initializer {
            AddViewModel(aplikasiPet().container.petRepositori)
        }
    }


}