package com.example.roomDatabase.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomDatabase.data.model.Item
import com.example.roomDatabase.data.model.ItemAndUnit
import com.example.roomDatabase.data.model.Unit

@Dao
interface UserDao {

    @Transaction
    @Query("SELECT * FROM Item")
    fun getItemsWithUnit(): LiveData<List<ItemAndUnit>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addUnit(unit:Unit)
}