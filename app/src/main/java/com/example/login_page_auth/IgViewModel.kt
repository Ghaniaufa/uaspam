package com.example.login_page_auth

import android.app.usage.UsageEvents
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class IgViewModel @Inject constructor(
    val auth: FirebaseAuth
) : ViewModel() {

    val signedIn = mutableStateOf(false)
    val inProgress = mutableStateOf(false)
    val popupNotification = mutableStateOf<com.example.login_page_auth.Event<String>?>(null)

    fun onSignup(email: String, pass: String) {
        inProgress.value = true

        auth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    signedIn.value = true
                    handleException(it.exception, "signup successful")
                }
                else {
                    handleException(it.exception, "signup failed")
                }
                inProgress.value = false
            }
    }


