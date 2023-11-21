package com.example.massive_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class chat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        data class Message(val content: String, val isUser: Boolean)

    }
}