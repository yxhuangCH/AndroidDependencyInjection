package com.yxhuang.di.dagger.di

import com.yxhuang.di.dagger.registration.enterdetails.EnterDetailsFragment
import com.yxhuang.di.dagger.registration.termsandconditions.TermsAndConditionsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by yxhuang
 * Date: 2023/7/31
 * Description:
 */
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun enterDetailsFragment(): EnterDetailsFragment

    @ContributesAndroidInjector
    abstract fun termsAndConditionsFragment(): TermsAndConditionsFragment

}