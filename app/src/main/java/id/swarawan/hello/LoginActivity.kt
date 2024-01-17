package id.swarawan.hello

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : Activity() {

    private lateinit var loginButton: Button
    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        loginButton = findViewById(R.id.login_button)
        inputEmail = findViewById(R.id.input_email)
        inputPassword = findViewById(R.id.input_password)

        loginButton.setOnClickListener {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            val validEmail = validateAccount(email, password)
            when {
                validEmail -> goToMainPage()
                else -> printErrorMessage()
            }
        }
    }

    private fun goToMainPage() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun printErrorMessage() {
        Toast.makeText(this, "Email atau password salah", Toast.LENGTH_SHORT).show()
    }

    private fun validateAccount(email: String, password: String): Boolean {
        return email.equals("rio@mail.com", true) &&
                password.equals("abcdxyz", true)
    }
}