package com.example.roomDatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
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
        subscribe()
        userViewModel.addUser(User(firstName = "joko", lastName = "haris", age = 20))
        userViewModel.userUpdate(1, "dika", "rengga", 11)
        userViewModel.delete(User(2, firstName = "joko", lastName = "haris", age = 20))
        findUserById(1)
    }

    private fun initViewModel() {
        userViewModel = ViewModelProvider(this,
                object : ViewModelProvider.Factory {
                    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                        val userDao = UserDatabase.getDatabase(this@MainActivity).dao()
                        val userRepository = UserRepository(userDao)
                        return UserViewModel(userRepository) as T
                    }
                }).get(UserViewModel::class.java)
            }

        private fun subscribe() {
            userViewModel.usersList.observe(this, Observer<List<User>> {
                Log.d("OUTPUT", "$it")
            })
        }

        private fun findUserById(id:Int){
            userViewModel.getUserById(id).observe(this, Observer<List<User>> {
                Log.d("FIND ID", "$it")
            })
        }
    }
