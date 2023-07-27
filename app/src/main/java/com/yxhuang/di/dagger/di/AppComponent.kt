package com.yxhuang.di.dagger.di

import android.content.Context
import com.yxhuang.di.dagger.login.di.LoginComponent
import com.yxhuang.di.dagger.main.MainActivity
import com.yxhuang.di.dagger.main.di.MainComponent
import com.yxhuang.di.dagger.registration.di.RegistrationComponent
import com.yxhuang.di.dagger.setting.di.SettingComponent
import com.yxhuang.di.dagger.user.UserDataRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by yxhuang
 * Date: 2023/7/24
 * Description:
 */
@Singleton
// Definition of a Dagger component that adds from the different modules to the graph
@Component(modules = [
    AppModuleBinds::class,
    ViewModelBuilderModule::class,
    StorageModule::class,
    AppSubcomponents::class])
interface AppComponent {
    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    // Types that can be retrieved from the graph
    fun mainComponent(): MainComponent.Factory
    fun settingComponent(): SettingComponent.Factory
    fun loginComponent(): LoginComponent.Factory
    fun registrationComponent(): RegistrationComponent.Factory


}