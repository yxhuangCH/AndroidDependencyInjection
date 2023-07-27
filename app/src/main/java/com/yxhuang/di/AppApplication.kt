package com.yxhuang.di

import android.app.Application
import com.yxhuang.di.dagger.di.AppComponent
import com.yxhuang.di.dagger.di.DaggerAppComponent
import com.yxhuang.di.dagger.storage.SharedPreferencesStorage
import com.yxhuang.di.dagger.user.UserManager

/**
 * Created by yxhuang
 * Date: 2023/6/6
 * Description:
 */
class AppApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

    internal val userManager by lazy {
        UserManager(SharedPreferencesStorage(this))
    }
}