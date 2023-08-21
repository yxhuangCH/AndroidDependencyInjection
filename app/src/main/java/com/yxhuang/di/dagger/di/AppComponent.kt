package com.yxhuang.di.dagger.di

import android.content.Context
import com.yxhuang.di.AppApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by yxhuang
 * Date: 2023/7/24
 * Description:
 */
@Singleton
// Definition of a Dagger component that adds from the different modules to the graph
@Component(modules = [
    AndroidInjectionModule::class,
    AppModuleBinds::class,
    ViewModelBuilderModule::class,
    StorageModule::class,
    AppSubcomponents::class,
    ActivitiesModule::class,
    FragmentBuildersModule::class,
    AndroidSupportInjectionModule::class
])
interface AppComponent :AndroidInjector<AppApplication> {
    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

}