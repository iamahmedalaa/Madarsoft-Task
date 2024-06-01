package com.example.madarsoft_task.data.repository

import com.example.madarsoft_task.data.dataModel.User
import com.example.madarsoft_task.data.db.UserDao
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {

    suspend fun saveUser(user: User) {
        userDao.insertUser(user)
    }

    fun getSavedUsers(): Flow<List<User>> {
        return userDao.getAllUsers()
    }
}
