package com.yxhuang.di.dagger.setting.di

import dagger.Subcomponent

/**
 * Created by yxhuang
 * Date: 2023/7/26
 * Description:
 */
@Subcomponent
interface SettingComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): SettingComponent
    }
}
