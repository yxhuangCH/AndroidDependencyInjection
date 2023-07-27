package com.yxhuang.di.dagger.login.di

import com.yxhuang.di.dagger.login.LoginActivity
import dagger.Subcomponent

/**
 * Created by yxhuang
 * Date: 2023/7/26
 * Description:
 */
@Subcomponent
interface LoginComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): LoginComponent
    }

    fun inject(activity: LoginActivity)
}