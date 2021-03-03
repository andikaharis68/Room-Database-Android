package com.example.roomDatabase.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM mst_user ORDER BY id ASC")
    fun readAllUser(): LiveData<List<User>>

    @Delete
    suspend fun delete(user: User)

    @Query("SELECT * FROM mst_user WHERE id = :id")
    fun getById(id: Int) : LiveData<List<User>>

    @Query("UPDATE mst_user SET firstName =:firstName, lastName =:lastName, age =:age WHERE id =:id")
    suspend fun update(id: Int, firstName:String, lastName:String, age:Int)

}