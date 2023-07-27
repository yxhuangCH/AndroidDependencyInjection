package com.yxhuang.di.dagger.di

import com.yxhuang.di.dagger.storage.SharedPreferencesStorage
import com.yxhuang.di.dagger.storage.Storage
import dagger.Binds
import dagger.Module

/**
 * Created by yxhuang
 * Date: 2023/7/25
 * Description:
 */
@Module
abstract class StorageModule {

    // Makes Dagger provide SharedPreferencesStorage when a Storage type is requested
    @Binds
    abstract fun provideStore(store: SharedPreferencesStorage): Storage
}