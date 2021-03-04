package com.example.roomDatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomDatabase.data.InventoryDatabase
import com.example.roomDatabase.data.UserRepository
import com.example.roomDatabase.data.UserViewModel
import com.example.roomDatabase.data.model.ItemAndUnit
import com.example.roomDatabase.data.model.Unit

//Rom database mirip meyimpan data ke database
//databasenya namanya sql lite
class MainActivity : AppCompatActivity() {

    lateinit var userViewModel: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
//        userViewModel.addUnit(Unit(code = "kg", description="kilogram"))
        subscribe()
    }

    private fun initViewModel() {
        userViewModel = ViewModelProvider(this,
                object : ViewModelProvider.Factory {
                    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                        val userDao = InventoryDatabase.getDatabase(this@MainActivity).dao()
                        val userRepository = UserRepository(userDao)
                        return UserViewModel(userRepository) as T
                    }
                }).get(UserViewModel::class.java)
            }

        private fun subscribe() {
            userViewModel.usersList.observe(this, Observer<List<ItemAndUnit>> {
                Log.d("OUTPUT", "$it")
            })
        }
    }
