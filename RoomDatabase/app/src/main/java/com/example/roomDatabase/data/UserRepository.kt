package com.example.roomDatabase.data

import androidx.lifecycle.LiveData
import com.example.roomDatabase.data.model.Item
import com.example.roomDatabase.data.model.ItemAndUnit
import com.example.roomDatabase.data.model.Unit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepository(private val dao: UserDao) {

    fun getItemWithUnit() :LiveData<List<ItemAndUnit>> {
        return dao.getItemsWithUnit()
    }

    fun addUnit(unit:Unit){
        CoroutineScope(Dispatchers.IO).launch {
            dao.addUnit(unit)
        }
    }
}