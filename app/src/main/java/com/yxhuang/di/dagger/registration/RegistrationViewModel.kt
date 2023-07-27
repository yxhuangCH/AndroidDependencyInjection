package com.yxhuang.di.dagger.registration

import androidx.lifecycle.ViewModel
import com.yxhuang.di.dagger.user.UserManager
import javax.inject.Inject

/**
 * Created by yxhuang
 * Date: 2023/7/2
 * Description:
 */
class RegistrationViewModel @Inject constructor(
    private val userManager: UserManager
) : ViewModel() {

    private var username: String? = null
    private var password: String? = null
    private var acceptedTCs: Boolean? = null

    fun updateUserData(username: String, password: String) {
        this.username = username
        this.password = password
    }

    fun acceptTCs() {
        acceptedTCs = true
    }

    fun registerUser() {
        assert(username != null)
        assert(password != null)
        assert(acceptedTCs == true)

        userManager.registerUser(username!!, password!!)
    }
}