package com.example.contact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.contact.databinding.ActivityLoginBinding
import com.example.contact.repository.UsersRepository

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var repository: UsersRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        repository = UsersRepository(this)
        login()
    }



    private fun login(){
      with(binding){
          val email = emailText.text.toString()
          val password = passwordText.text.toString()

              saveButton.setOnClickListener {
              repository.allUser().observe(this@LoginActivity, Observer {userTable->
                  userTable.forEach { user->
                    if (email.contentEquals(user.email) && password.contentEquals(user.password)){
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()

                    }else{
                        Toast.makeText(this@LoginActivity, "All Field are required", Toast.LENGTH_SHORT).show()
                    }
                  }
              })
          }
      }
  }
}