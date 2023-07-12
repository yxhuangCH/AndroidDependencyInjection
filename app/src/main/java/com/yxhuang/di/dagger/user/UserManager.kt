package com.yxhuang.di.dagger.user

import com.yxhuang.di.dagger.storage.Storage

/**
 * Created by yxhuang
 * Date: 2023/6/20
 * Description:
 */
class UserManager(
    private val storage: Storage
) {
    companion object {
        private const val REGISTERED_USER = "registered_user"
        private const val PASSWORD_SUFFIX = "password"
    }

    var userDataRepository: UserDataRepository? = null

    fun isUserLoggedIn() = userDataRepository != null

    fun isUserRegistered() = storage.getString(REGISTERED_USER).isNotEmpty()

    val userName: String
        get() = storage.getString(REGISTERED_USER)

    fun loginUser(userName: String, password: String): Boolean {
        val registerUser = this.userName
        if (registerUser != userName) {
            return false
        }
        val registerPassword = storage.getString("$userName$PASSWORD_SUFFIX")
        if (registerPassword != password) {
            return false
        }
        userJustLoggedIn()
        return true
    }

    fun logout() {
        userDataRepository = null
    }

    fun registerUser(userName: String, password: String) {
        storage.setString(REGISTERED_USER, userName)
        storage.setString("$userName$PASSWORD_SUFFIX", password)
        userJustLoggedIn()
    }

    fun unregister() {
        val userName = storage.getString(REGISTERED_USER)
        storage.setString("REGISTERED_USER", "")
        storage.setString("$userName$PASSWORD_SUFFIX", "")
        logout()
    }

    private fun userJustLoggedIn() {
        if (userDataRepository == null) {
            userDataRepository = UserDataRepository(this)
        }
    }
}