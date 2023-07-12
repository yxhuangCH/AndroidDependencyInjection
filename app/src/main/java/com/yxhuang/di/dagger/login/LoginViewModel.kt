package com.yxhuang.di.dagger.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yxhuang.di.dagger.user.UserManager

/**
 * Created by yxhuang
 * Date: 2023/7/2
 * Description:
 */
class LoginViewModel(
    private val userManager: UserManager
) : ViewModel() {

    private val _loginState = MutableLiveData<LoginViewState>()
    val loginState : LiveData<LoginViewState>
        get() = _loginState

    fun login(userName: String, password: String){
        if (userManager.loginUser(userName, password)) {
            _loginState.value = LoginSuccess
        } else {
            _loginState.value = LoginError
        }
    }

    fun unregister() {
        userManager.unregister()
    }

    fun getUserName(): String = userManager.userName

}