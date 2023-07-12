package com.yxhuang.di.dagger.login

/**
 * Created by yxhuang
 * Date: 2023/7/2
 * Description:
 */
sealed interface LoginViewState

object LoginSuccess: LoginViewState

object LoginError: LoginViewState

