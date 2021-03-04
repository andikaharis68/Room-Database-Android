package com.example.roomDatabase.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Unit(
        @PrimaryKey(autoGenerate = true) val id: Int=0,
        val code: String?,
        val description: String?
)