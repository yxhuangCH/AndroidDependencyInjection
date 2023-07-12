package com.yxhuang.di.dagger.setting

import androidx.lifecycle.ViewModel
import com.yxhuang.di.dagger.user.UserDataRepository
import com.yxhuang.di.dagger.user.UserManager

/**
 * Created by yxhuang
 * Date: 2023/7/8
 * Description:
 */
class SettingsViewModel(
    private val userDataRepository: UserDataRepository,
    private val userManager: UserManager
) : ViewModel() {

    fun refreshNotifications() {
        userDataRepository.refreshUnreadNotifications()
    }

    fun logout() {
        userManager.logout()
    }


}