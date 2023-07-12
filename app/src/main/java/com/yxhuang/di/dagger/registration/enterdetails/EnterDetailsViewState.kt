package com.yxhuang.di.dagger.registration.enterdetails

/**
 * Created by yxhuang
 * Date: 2023/7/2
 * Description:
 */
sealed interface EnterDetailsViewState

object EnterDetailsSuccess : EnterDetailsViewState

data class EnterDetailsError(
        val error: String
) : EnterDetailsViewState