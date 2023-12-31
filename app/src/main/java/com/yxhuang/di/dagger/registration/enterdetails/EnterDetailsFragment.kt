package com.yxhuang.di.dagger.registration.enterdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.yxhuang.di.R
import com.yxhuang.di.dagger.registration.RegistrationActivity
import com.yxhuang.di.dagger.registration.RegistrationViewModel

/**
 * Created by yxhuang
 * Date: 2023/7/2
 * Description:
 */
class EnterDetailsFragment : Fragment() {

    private lateinit var registrationViewModel: RegistrationViewModel
    private lateinit var enterDetailsViewModel: EnterDetailsViewModel

    private lateinit var errorTextView: TextView
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?)
    : View? {
        val view = inflater.inflate(R.layout.fragment_enter_details, container, false)

        registrationViewModel = (activity as RegistrationActivity).registrationViewModel
        enterDetailsViewModel = EnterDetailsViewModel()
        enterDetailsViewModel.enterDetailsViewState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is EnterDetailsSuccess ->{
                    val userName = usernameEditText.text.toString().trim()
                    val password = passwordEditText.text.toString().trim()
                    registrationViewModel.updateUserData(userName, password)

                    (activity as RegistrationActivity).onDetailEntered()
                }
                is EnterDetailsError -> {
                    errorTextView.text = state.error
                    errorTextView.visibility = View.VISIBLE
                }
            }
        }

        setupView(view)
        return view
    }

    private fun setupView(view: View) {
        errorTextView = view.findViewById(R.id.error)

        usernameEditText = view.findViewById(R.id.username)
        usernameEditText.doOnTextChanged { text, start, before, count ->
            errorTextView.visibility = View.INVISIBLE
        }

        passwordEditText = view.findViewById(R.id.password)
        passwordEditText.doOnTextChanged { text, start, before, count ->
            errorTextView.visibility = View.INVISIBLE
        }

        view.findViewById<Button>(R.id.next).setOnClickListener {
            val userName = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            enterDetailsViewModel.validateInput(userName, password)
        }
    }
}