package com.yxhuang.di.dagger.registration.enterdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

/**
 * Created by yxhuang
 * Date: 2023/7/2
 * Description:
 */
class EnterDetailsViewModel @Inject constructor(): ViewModel() {

    companion object {
        private const val MAX_LENGTH = 5
    }

    private val _enterDetailsState = MutableLiveData<EnterDetailsViewState>()
    val enterDetailsViewState: LiveData<EnterDetailsViewState>
        get() = _enterDetailsState

    fun validateInput(userName: String, password: String) {
        when {
            userName.length < MAX_LENGTH -> {
                _enterDetailsState.value = EnterDetailsError("Username has to be longer than 4 characters")
            }
            password.length < MAX_LENGTH -> {
                _enterDetailsState.value = EnterDetailsError("Password has to be longer than 4 characters")
            }
            else -> {
                _enterDetailsState.value = EnterDetailsSuccess
            }
        }
    }
}