package com.example.login_page_auth

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

fun CreationExtras.FirebaseAuthenticationApp(): FirebaseAuthenticationApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as FirebaseAuthenticationApp)