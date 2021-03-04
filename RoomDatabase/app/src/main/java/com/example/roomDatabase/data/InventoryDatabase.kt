package com.example.roomDatabase.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomDatabase.data.model.Item
import com.example.roomDatabase.data.model.Unit

@Database(entities = [Item::class, Unit::class], version = 2, exportSchema = false)
abstract class InventoryDatabase: RoomDatabase() {

    abstract fun dao(): UserDao

    companion object {
        @Volatile
        private var INTANCE: InventoryDatabase? = null

        fun getDatabase(context: Context): InventoryDatabase {
            //            cara kotlin
            return INTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        InventoryDatabase::class.java,
                        "inven_database"
                ).build()
                INTANCE = instance
                instance
            }

//            cara panjang
//            val tempInstance = INTANCE
//            if (tempInstance != null) {
//                return tempInstance
//            }
//
//            synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    InventoryDatabase::class.java,
//                    "user_database"
//                ).build()
//                INTANCE = instance
//                return instance
//            }
        }
    }
}