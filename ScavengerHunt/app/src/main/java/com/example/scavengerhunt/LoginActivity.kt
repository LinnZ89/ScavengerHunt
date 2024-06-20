package com.example.scavengerhunt

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge if required, otherwise this can be removed or customized
        enableEdgeToEdge()

        // Set the correct layout resource
        setContentView(R.layout.activity_login)

        // Initialize UI components
        usernameInput = findViewById(R.id.username_input)
        passwordInput = findViewById(R.id.password_input)
        loginButton = findViewById(R.id.loginbtn)

        // Set the login button click listener
        loginButton.setOnClickListener {
            val username = usernameInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            // Perform basic validation (replace with actual authentication logic)
            if (isValidCredentials(username, password)) {
                // Log the credentials for debugging
                Log.i("LoginActivity", "Valid credentials. Username: $username, Password: $password")

                // Save login state or token (this can be done using SharedPreferences or similar)

                // Navigate to MainMenuActivity
                navigateToMainMenu()
            } else {
                // Show error message or toast for invalid credentials
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Function to perform basic validation (replace with actual authentication logic)
    private fun isValidCredentials(username: String, password: String): Boolean {
        // For demo purposes, check if username and password match a predefined value
        return username == "admin" && password == "password"
    }

    // Function to navigate to MainMenuActivity
    private fun navigateToMainMenu() {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
        finish() // Finish LoginActivity to prevent user from returning using back button
    }

    // Function to enable edge-to-edge mode (if needed)
    private fun enableEdgeToEdge() {
        // Apply the configuration for edge-to-edge mode
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // For Android 11 and above
            window.setDecorFitsSystemWindows(false)

            window.insetsController?.apply {
                // Make the status bar and navigation bar transparent
                setSystemBarsAppearance(
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS or
                            WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS,
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS or
                            WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS
                )
                // Hide the navigation bar for full-screen mode
                hide(WindowInsets.Type.navigationBars())
            }
        } else {
            // For Android 10 and below
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    )
        }

        // Optionally, set the status bar and navigation bar color to transparent
        window.statusBarColor = android.graphics.Color.TRANSPARENT
        window.navigationBarColor = android.graphics.Color.TRANSPARENT
    }
}
