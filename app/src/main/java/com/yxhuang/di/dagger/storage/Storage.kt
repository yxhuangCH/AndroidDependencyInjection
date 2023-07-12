package com.yxhuang.di.dagger.storage

/**
 * Created by yxhuang
 * Date: 2023/6/20
 * Description:
 */
interface Storage {

    fun setString(key: String, value: String)

    fun getString(key: String): String
}