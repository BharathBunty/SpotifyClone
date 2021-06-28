package com.bharath.spotifyclone.data.remote

import com.bharath.spotifyclone.data.entities.Song
import com.bharath.spotifyclone.helper.Constants.SONG_COLLECTION
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class SongDatabase {

    private val fireStore  = FirebaseFirestore.getInstance()
    private val songCollection = fireStore.collection(SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song>{
        return try{
             songCollection.get().await().toObjects(Song::class.java)
        }catch (exception: Exception){
             emptyList()
        }
    }
}