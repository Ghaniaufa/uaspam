package com.example.login_page_auth

data class AddUIState(
    val addEvent: AddEvent = AddEvent(),
)

data class AddEvent(
    val id: String ="",
    val namapet: String = "",
    val jenidpet: String = "",
    val telpon: String = "",
)