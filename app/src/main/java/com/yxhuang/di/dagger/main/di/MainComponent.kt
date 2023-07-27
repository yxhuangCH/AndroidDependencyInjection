package com.yxhuang.di.dagger.main.di

import com.yxhuang.di.dagger.main.MainActivity
import dagger.Subcomponent

/**
 * Created by yxhuang
 * Date: 2023/7/23
 * Description:
 */
@Subcomponent
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    // Class that can be injected by this Component
    fun inject(activity: MainActivity)
}