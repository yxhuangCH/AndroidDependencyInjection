package com.yxhuang.di.dagger.di

import com.yxhuang.di.dagger.login.di.LoginComponent
import com.yxhuang.di.dagger.main.di.MainComponent
import com.yxhuang.di.dagger.registration.di.RegistrationComponent
import com.yxhuang.di.dagger.setting.di.SettingComponent
import dagger.Module

/**
 * Created by yxhuang
 * Date: 2023/7/23
 * Description:
 */
@Module(subcomponents = [
    MainComponent::class,
    SettingComponent::class,
    LoginComponent::class,
    RegistrationComponent::class
])
object AppSubcomponents