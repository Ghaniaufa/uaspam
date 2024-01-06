package com.example.login_page_auth.repositori

import android.content.ContentValues
import android.util.Log
import com.example.login_page_auth.model.Pet
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await


interface PetRepositori {
    fun getAll(): Flow<List<Pet>>
    suspend fun add(pet: Pet): String
    suspend fun update(pet: Pet)
    suspend fun delete(petId: String)
    fun getPetById(petId: String):Flow<Pet>

}
class PetRepositoriImpl(private val firestore: FirebaseFirestore): PetRepositori{
    override fun getAll(): Flow<List<Pet>> = flow{
        val snapshot = firestore.collection("Pet")
            .orderBy("namapet", Query.Direction.ASCENDING)
            .get()
            .await()
        val pet = snapshot.toObjects(Pet::class.java)
        emit(pet)
    }.flowOn(Dispatchers.IO)

    override suspend fun add(pet: Pet): String {
        return try {
            val documentReference = firestore.collection("Pet").add(pet).await()

            firestore.collection("Pet").document(documentReference.id)
                .set(pet.copy(id = documentReference.id))
            "Succes + ${documentReference.id}"
        } catch (e: Exception){
            Log.w(ContentValues.TAG,"Error adding document",e)
            "Failed $e"
        }
    }
}