package com.example.login_page_auth

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.login_page_auth.home.HomeViewModel
import com.example.login_page_auth.login.IgViewModel

fun CreationExtras.aplikasiPet(): FirebaseAuthenticationApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as FirebaseAuthenticationApp)

object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            HomeViewModel(aplikasiPet().container.petRepositori)
        }
    }


}