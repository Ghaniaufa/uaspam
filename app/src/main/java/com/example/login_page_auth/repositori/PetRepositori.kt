package com.example.login_page_auth.repositori

import com.example.login_page_auth.model.Pet
import kotlinx.coroutines.flow.Flow

interface PetRepositori {
    fun getAll(): Flow<List<Pet>>
    suspend fun add(pet: Pet): String
    suspend fun update(pet: Pet)
    suspend fun delete(petId: String)
    fun getPetById(petId: String):Flow<Pet>

}