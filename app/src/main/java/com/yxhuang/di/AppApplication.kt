package com.yxhuang.di

import android.app.Application
import com.yxhuang.di.dagger.di.AppComponent
import com.yxhuang.di.dagger.di.DaggerAppComponent
import com.yxhuang.di.dagger.storage.SharedPreferencesStorage
import com.yxhuang.di.dagger.user.UserManager
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Created by yxhuang
 * Date: 2023/6/6
 * Description:
 */
class AppApplication : Application(), HasAndroidInjector {

    internal val userManager by lazy {
        UserManager(SharedPreferencesStorage(this))
    }

    lateinit var appComponent: AppComponent

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(applicationContext)
        appComponent.inject(this)
    }
}
