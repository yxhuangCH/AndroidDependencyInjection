package com.yxhuang.di

import android.app.Application
import com.yxhuang.di.dagger.storage.SharedPreferencesStorage
import com.yxhuang.di.dagger.user.UserManager

/**
 * Created by yxhuang
 * Date: 2023/6/6
 * Description:
 */
class AppApplication : Application() {

    internal val userManager by lazy {
        UserManager(SharedPreferencesStorage(this))
    }
}