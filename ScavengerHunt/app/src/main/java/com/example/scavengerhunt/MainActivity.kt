package com.example.scavengerhunt

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        if (isLoggedIn()) {
            navigateToMenu()
        } else {
            return
        }
    }

    private fun isLoggedIn(): Boolean {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        return true // Return true if user is logged in, false otherwise
    }

    private fun navigateToMenu() {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }
}
