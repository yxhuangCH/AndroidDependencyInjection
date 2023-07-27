package com.yxhuang.di.dagger.setting

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.yxhuang.di.AppApplication
import com.yxhuang.di.R
import com.yxhuang.di.dagger.login.LoginActivity
import javax.inject.Inject

/**
 * Created by yxhuang
 * Date: 2023/6/28
 * Description:
 */
class SettingsActivity: AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val settingsViewModel by viewModels<SettingsViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        (application as AppApplication).appComponent.settingComponent().create().inject(this)
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_settings)

//        val userManager = (application as AppApplication).userManager

//        settingsViewModel = SettingsViewModel(
//            userManager.userDataRepository!!,
//            userManager
//        )

        setupViews()
    }

    private fun setupViews() {
        findViewById<Button>(R.id.refresh).setOnClickListener {
            settingsViewModel.refreshNotifications()
        }
        findViewById<Button>(R.id.logout).setOnClickListener {
            settingsViewModel.logout()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK  or
                    Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}