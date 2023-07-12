package com.yxhuang.di.dagger.registration.termsandconditions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.yxhuang.di.R
import com.yxhuang.di.dagger.registration.RegistrationActivity
import com.yxhuang.di.dagger.registration.RegistrationViewModel

/**
 * Created by yxhuang
 * Date: 2023/7/2
 * Description:
 */
class TermsAndConditionsFragment : Fragment() {

    private lateinit var registrationViewModel: RegistrationViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_terms_and_conditions, container, false)

        registrationViewModel = (activity as RegistrationActivity).registrationViewModel

        view.findViewById<Button>(R.id.next).setOnClickListener {
            registrationViewModel.acceptTCs()
            (activity as RegistrationActivity).onTermsAndConditionsAccepted()
        }
        return view
    }
}