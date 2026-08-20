package com.example.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pipes")
data class PipeEntity(
  @PrimaryKey val id: String,
  @ColumnInfo val length: Double,
  @ColumnInfo val diameter: Double,
  @ColumnInfo val slope: Double,
  @ColumnInfo val manningsN: Double,
  @ColumnInfo val hwCoeff: Double
)
