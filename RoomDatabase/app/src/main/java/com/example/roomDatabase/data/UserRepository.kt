package com.example.roomDatabase.data

import androidx.lifecycle.LiveData

class UserRepository(private val dao: UserDao) {
    val usersList: LiveData<List<User>> =  dao.readAllUser()

    suspend fun addUser(user: User) {
        dao.addUser(user)
    }
}