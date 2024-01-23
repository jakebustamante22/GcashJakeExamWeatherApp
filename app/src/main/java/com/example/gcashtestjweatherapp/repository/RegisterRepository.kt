package com.example.gcashtestjweatherapp.repository


import com.example.gcashtestjweatherapp.database.RegisterDatabaseDao
import com.example.gcashtestjweatherapp.database.RegisterEntity

class RegisterRepository(private val dao: RegisterDatabaseDao) {

    val users = dao.getAllUsers()

    suspend fun insert(user: RegisterEntity) {
        return dao.insert(user)
    }

    suspend fun getUserName(userName: String):RegisterEntity?{
        return dao.getUsername(userName)
    }
}