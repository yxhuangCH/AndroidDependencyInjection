package com.yxhuang.di.dagger.storage

import android.content.Context
import android.util.Log
import com.yxhuang.di.dagger.MAIN_TAG
import javax.inject.Inject

/**
 * Created by yxhuang
 * Date: 2023/6/28
 * Description:
 */
class SharedPreferencesStorage @Inject constructor(context: Context) : Storage {

    private val sharedPreferences = context.getSharedPreferences("Dagger", Context.MODE_PRIVATE)

    override fun setString(key: String, value: String) {
        Log.i(MAIN_TAG, "setString key=$key value=$value")
        with(sharedPreferences.edit()){
            putString(key, value)
            apply()
        }
    }

    override fun getString(key: String): String {
        Log.i(MAIN_TAG, "getString key=$key")
        return sharedPreferences.getString(key, "")!!
    }

}