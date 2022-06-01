package com.example.basicsroomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.basicsroomapp.database.User

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//      Guardar usuarios



//        mainViewModel.saveUser(User(
//            "user1",
//            "name1",
//            1.82,
//            70.0,
//            "user@email.com",
//            "valor"
//
//        ))

        mainViewModel.getUsers()

        mainViewModel.savedUsers.observe(this) {usersList ->
            if(!usersList.isNullOrEmpty()){
                for(user in usersList){
                    Log.d("thesearetheusers", user.user_name)
                }
            }else{
                Log.d("thesearetheusers", "null or empty")
            }
        }
    }
}