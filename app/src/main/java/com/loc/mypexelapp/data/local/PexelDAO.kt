package com.loc.mypexelapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

//@Dao
//interface PexelDAO {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun upsertCollectionHeader(collection: Collection)
//
//    @Delete
//    fun deleteCollectionHeader(collection: Collection)
//
//    @Query("SELECT * FROM Collection")
//    suspend fun getAllCollectionHeaders()
//
//}