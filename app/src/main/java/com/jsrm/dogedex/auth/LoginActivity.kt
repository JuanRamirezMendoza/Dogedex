package com.jsrm.dogedex.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jsrm.dogedex.R
import com.jsrm.dogedex.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}