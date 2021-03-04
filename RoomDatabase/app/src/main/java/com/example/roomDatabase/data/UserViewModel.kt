package com.example.roomDatabase.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.roomDatabase.data.model.ItemAndUnit
import com.example.roomDatabase.data.model.Unit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository): ViewModel() {

    val usersList: LiveData<List<ItemAndUnit>> = repository.getItemWithUnit()

    fun addUnit(unit:Unit){
        CoroutineScope(Dispatchers.IO).launch {
            repository.addUnit(unit)
        }
    }
}