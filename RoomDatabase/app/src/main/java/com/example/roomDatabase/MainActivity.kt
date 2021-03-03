package com.example.roomDatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomDatabase.data.User
import com.example.roomDatabase.data.UserDatabase
import com.example.roomDatabase.data.UserRepository
import com.example.roomDatabase.data.UserViewModel

//Rom database mirip meyimpan data ke database
//databasenya namanya sql lite
class MainActivity : AppCompatActivity() {

    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        userViewModel.addUser(User(firstName="joko", lastName="haris", age=20))
    }

    private fun initViewModel() {
        userViewModel = ViewModelProvider(this,
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    val userDao = UserDatabase.getDatabase(this@MainActivity).dao()
                    val userRepository = UserRepository(userDao)
                    return UserViewModel(userRepository) as T
                }
            }).get(UserViewModel::class.java)
    }
}