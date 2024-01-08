package com.example.login_page_auth

import com.example.login_page_auth.model.Pet

data class AddUIState(
    val addEvent: AddEvent = AddEvent(),
)

data class AddEvent(
    val id: String ="",
    val namapet: String = "",
    val jenispet: String = "",
    val telpon: String = "",
)

fun AddEvent.toPet() = Pet(
    id = id,
    namapet = namapet,
    jenispet = jenispet,
    telpon = telpon
)

data class DetailUIState(
    val addEvent: AddEvent = AddEvent(),
)

fun Pet.toDetailPet(): AddEvent =
    AddEvent(
        id = id,
        namapet = namapet,
        jenispet = jenispet,
        telpon = telpon
    )
fun  Pet.toUIStatePet(): AddUIState = AddUIState(
    addEvent = this.toDetailPet()
)
data class HomeUIState(
    val listPet: List<Pet> = listOf(),
    val datalength: Int =0
)