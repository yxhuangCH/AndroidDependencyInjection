package com.yxhuang.di.dagger.registration.di

import com.yxhuang.di.dagger.registration.RegistrationActivity
import com.yxhuang.di.dagger.registration.enterdetails.EnterDetailsFragment
import com.yxhuang.di.dagger.registration.termsandconditions.TermsAndConditionsFragment
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

    fun inject(activity: RegistrationActivity)

    fun inject(fragment: EnterDetailsFragment)

    fun inject(fragment: TermsAndConditionsFragment)

}