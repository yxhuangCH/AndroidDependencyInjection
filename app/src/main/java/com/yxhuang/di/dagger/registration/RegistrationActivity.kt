package com.yxhuang.di.dagger.registration

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yxhuang.di.AppApplication
import com.yxhuang.di.R
import com.yxhuang.di.dagger.main.MainActivity
import com.yxhuang.di.dagger.registration.enterdetails.EnterDetailsFragment
import com.yxhuang.di.dagger.registration.termsandconditions.TermsAndConditionsFragment

/**
 * Created by yxhuang
 * Date: 2023/7/2
 * Description:
 */
class RegistrationActivity : AppCompatActivity() {

    lateinit var registrationViewModel: RegistrationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        registrationViewModel = RegistrationViewModel((application as AppApplication).userManager)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_holder, EnterDetailsFragment())
            .commit()
    }

    fun onDetailEntered() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_holder, TermsAndConditionsFragment())
            .addToBackStack(TermsAndConditionsFragment::class.java.simpleName)
            .commit()
    }

    fun onTermsAndConditionsAccepted() {
        registrationViewModel.registerUser()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

}