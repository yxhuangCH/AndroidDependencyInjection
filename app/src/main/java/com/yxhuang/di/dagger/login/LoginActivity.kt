package com.yxhuang.di.dagger.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.yxhuang.di.R
import com.yxhuang.di.dagger.main.MainActivity
import com.yxhuang.di.dagger.registration.RegistrationActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * Created by yxhuang
 * Date: 2023/7/2
 * Description:
 */
class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<LoginViewModel> { viewModelFactory }


    private lateinit var errorTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel.loginState.observe(this){ state ->
            when(state) {
                is LoginSuccess -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
                is LoginError -> errorTextView.visibility = View.VISIBLE
            }
        }

        errorTextView = findViewById(R.id.error)
        setupViews()
    }

    private fun setupViews() {
        val userNameEditText = findViewById<EditText>(R.id.username)
        userNameEditText.isEnabled = false
        userNameEditText.setText(viewModel.getUserName())

        val passwordEditText = findViewById<EditText>(R.id.password)
        passwordEditText.doOnTextChanged { text, start, before, count ->
            errorTextView.visibility = View.INVISIBLE
        }

        findViewById<Button>(R.id.login).setOnClickListener {
            viewModel.login(
                userNameEditText.text.toString().trim(),
                passwordEditText.text.toString().trim()
            )
        }
        findViewById<Button>(R.id.unregister).setOnClickListener {
            viewModel.unregister()
            val intent = Intent(this, RegistrationActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK or
                    Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

    }
}

