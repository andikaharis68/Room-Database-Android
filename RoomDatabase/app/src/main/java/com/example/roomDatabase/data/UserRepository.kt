package com.example.roomDatabase.data

import androidx.lifecycle.LiveData

class UserRepository(private val dao: UserDao) {
    private val usersList: LiveData<List<User>> = dao.readAllUser()

    suspend fun addUser(user: User) {
        dao.addUser(user)
    }

    fun getUser() : LiveData<List<User>>{
        return usersList
    }

    fun getUserById(id:Int): LiveData<List<User>>{
        return dao.getById(id)
    }

    suspend fun userUpdate(id: Int, firstName:String, lastName:String, age:Int){
        dao.update(id, firstName, lastName, age)
    }

    suspend fun delete(user: User){
        dao.delete(user)
    }
}