package com.example.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Delete
import kotlinx.coroutines.flow.Flow

@Dao
interface PipeDao {
  @Query("SELECT * FROM pipes")
  fun getAll(): Flow<List<PipeEntity>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insert(pipe: PipeEntity)

  @Delete
  suspend fun delete(pipe: PipeEntity)

  @Query("DELETE FROM pipes")
  suspend fun clear()
}
