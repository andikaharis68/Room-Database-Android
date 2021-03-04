package com.example.roomDatabase.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item (
    @PrimaryKey
    val id: Int,
    val name: String?,
    val unitId: Int,
    val price: Int
)

