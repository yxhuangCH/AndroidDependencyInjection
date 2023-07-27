package com.yxhuang.di.dagger.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yxhuang.di.dagger.MAIN_TAG
import com.yxhuang.di.dagger.user.UserDataRepository
import javax.inject.Inject

/**
 * Created by yxhuang
 * Date: 2023/6/28
 * Description:
 */
class MainViewModel @Inject constructor(
    private val userDataRepository: UserDataRepository
): ViewModel() {

    private val _welcomeText = MutableLiveData<String>()
    val welcomeText: LiveData<String>
        get() = _welcomeText

    fun getData() {
        Log.i(MAIN_TAG, "getData")

        val userName = userDataRepository.userName
        _welcomeText.value= userName
    }
}