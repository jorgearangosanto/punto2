package com.santo.practicandoparcial1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class splashactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this,RegisterActivity2::class.java))


    }
}