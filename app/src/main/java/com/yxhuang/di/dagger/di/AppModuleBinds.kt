package com.yxhuang.di.dagger.di

import com.yxhuang.di.dagger.user.UserDataRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by yxhuang
 * Date: 2023/7/24
 * Description:
 */
@Module
abstract class AppModuleBinds {

//    @Singleton
//    @Binds
//    abstract fun bindDataRepository(dataRepository: UserDataRepository): UserDataRepository
}