package com.example.login_page_auth.home

import com.example.login_page_auth.model.Pet
import kotlinx.coroutines.flow.Flow


sealed class PetUIState{
    data class Success(val pet: Flow<List<Pet>>): PetUIState()
    object Error : PetUIState()
    object  Loading : PetUIState()
}
class HomeViewModel {

}