package com.example.roomDatabase.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository): ViewModel() {

    val usersList: LiveData<List<User>> = repository.getUser()

    fun addUser(user:User) {
        CoroutineScope(Dispatchers.IO).launch{
            repository.addUser(user)
        }
    }

    fun getUserById(id:Int) : LiveData<List<User>>{
        return repository.getUserById(id)
    }

    fun userUpdate(id: Int, firstName:String, lastName:String, age:Int){
        CoroutineScope(Dispatchers.IO).launch {
            repository.userUpdate(id, firstName, lastName, age)
        }
    }

    fun delete(user: User){
        CoroutineScope(Dispatchers.IO).launch {
            repository.delete(user)
        }
    }
}