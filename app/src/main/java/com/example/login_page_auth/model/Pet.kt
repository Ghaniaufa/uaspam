package com.example.login_page_auth.model

data class Pet(
    val id: String,
    val namapet: String,
    val jenispet: String,
    val telpon: String,
){
    constructor(): this("","","","")
}
