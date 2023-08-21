package com.yxhuang.di.dagger.di

import com.yxhuang.di.dagger.login.LoginActivity
import com.yxhuang.di.dagger.main.MainActivity
import com.yxhuang.di.dagger.registration.RegistrationActivity
import com.yxhuang.di.dagger.setting.SettingsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by yxhuang
 * Date: 2023/7/31
 * Description:
 */

@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector
    abstract fun loginActivity(): LoginActivity

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun registrationActivity(): RegistrationActivity

    @ContributesAndroidInjector
    abstract fun settingsActivity(): SettingsActivity

}