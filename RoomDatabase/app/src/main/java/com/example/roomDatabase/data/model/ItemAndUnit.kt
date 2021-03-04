package com.example.roomDatabase.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

data class ItemAndUnit(
        @Embedded val item: Item,
        @Relation(
                parentColumn = "unitId",
                entityColumn = "id"
        )
        val unit: Unit
)