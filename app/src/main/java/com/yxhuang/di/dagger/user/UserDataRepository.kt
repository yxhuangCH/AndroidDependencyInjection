package com.yxhuang.di.dagger.user

import kotlin.random.Random

/**
 * Created by yxhuang
 * Date: 2023/6/20
 * Description:
 */
class UserDataRepository(
    private val userManager: UserManager
) {

    var unreadNotifications: Int

    val userName: String
        get() = userManager.userName

    init {
        unreadNotifications = randomInt()
    }

    fun refreshUnreadNotifications() {
        unreadNotifications = randomInt()
    }
}

fun randomInt(): Int {
    return Random.nextInt(until = 100)
}