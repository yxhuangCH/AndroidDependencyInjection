package com.yxhuang.di.dagger.registration.di

import dagger.Subcomponent

/**
 * Created by yxhuang
 * Date: 2023/7/27
 * Description:
 */
@Subcomponent
interface RegistrationComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): RegistrationComponent
    }

}
