package com.yxhuang.di.dagger.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.yxhuang.di.AppApplication
import com.yxhuang.di.R
import com.yxhuang.di.dagger.MAIN_TAG
import com.yxhuang.di.dagger.registration.RegistrationActivity
import com.yxhuang.di.dagger.setting.SettingsActivity


class MainActivity : AppCompatActivity() {

    private var mainViewModel: MainViewModel?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userManager = (application as AppApplication).userManager

        if (!userManager.isUserLoggedIn()){
            if (!userManager.isUserRegistered()){
                startActivity(Intent(this, RegistrationActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, SettingsActivity::class.java))
                finish()
            }
        } else {
            setContentView(R.layout.activity_main)

            mainViewModel = MainViewModel(userManager.userDataRepository!!)
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