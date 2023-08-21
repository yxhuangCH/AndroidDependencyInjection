package com.yxhuang.di.dagger.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.yxhuang.di.AppApplication
import com.yxhuang.di.R
import com.yxhuang.di.dagger.MAIN_TAG
import com.yxhuang.di.dagger.login.LoginActivity
import com.yxhuang.di.dagger.registration.RegistrationActivity
import com.yxhuang.di.dagger.setting.SettingsActivity
import dagger.android.AndroidInjection
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val mainViewModel by viewModels<MainViewModel> {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        val userManager = (application as AppApplication).userManager

        if (!userManager.isUserLoggedIn()){
            if (!userManager.isUserRegistered()){
                startActivity(Intent(this, RegistrationActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        } else {
            setContentView(R.layout.activity_main)

            setupViews()
            mainViewModel?.getData()
        }
    }


    private fun setupViews() {
        Log.i(MAIN_TAG, "setupViews")
        mainViewModel?.welcomeText?.observe(this) {
            Log.i(MAIN_TAG, "setupViews welcomeText: $it")
            findViewById<TextView>(R.id.hello).text = it
        }

        findViewById<Button>(R.id.settings).setOnClickListener {
            Log.i(MAIN_TAG, "setupViews settings click ")
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }

}