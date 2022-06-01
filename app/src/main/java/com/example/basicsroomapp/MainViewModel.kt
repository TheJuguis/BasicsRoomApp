package com.example.basicsroomapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basicsroomapp.database.User
import androidx.lifecycle.viewModelScope
import com.example.basicsroomapp.database.DatabaseManager
import com.example.basicsroomapp.database.MyCoroutines2
import kotlinx.coroutines.launch
import java.util.*

class MainViewModel: ViewModel() {
    fun saveUser(user: User){
        viewModelScope.launch{
            val userDao = DatabaseManager.instance.database.userDao()
            MyCoroutines2(userDao).save(user)
        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch{
            val userDao = DatabaseManager.instance.database.userDao()
            MyCoroutines2(userDao).delete(user)
        }
    }

    val savedUsers = MutableLiveData<List<User>>()
    fun getUsers(){
        viewModelScope.launch{
            val userDao = DatabaseManager.instance.database.userDao()
            savedUsers.value = MyCoroutines2(userDao).getUsers().value
        }
    }
    fun getUser(uuid: UUID){
        viewModelScope.launch {
            val userDao = DatabaseManager.instance.database.userDao()
            MyCoroutines2(userDao).getUser(uuid)
        }
    }
}