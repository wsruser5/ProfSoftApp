package com.mrz.profsoftapp.view

import android.app.ActivityOptions
import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Pair
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.mrz.profsoftapp.R
import com.mrz.profsoftapp.databinding.SigninScreenBinding


class SigninScreen : Fragment() {

    private var _binding: SigninScreenBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    private var email: String = ""
    private var password: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SigninScreenBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.etEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                email = binding.etEmail.text.toString()

                binding.btnSignIn.isEnabled = !(email == "" || password == "")
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        binding.etPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                password = binding.etPassword.text.toString()

                binding.btnSignIn.isEnabled = !(email == "" || password == "")
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        val builder = AlertDialog.Builder(this.context)
            .setTitle("Забыли пароль?")
            .setMessage("Напишите в поддержку academy@profsoft.pro")
            .setPositiveButton("Вернуться") { dialogInterface, i -> }

        binding.forgotPassword.setOnClickListener {
             builder.show()
        }

        binding.btnSignIn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_signinScreen_to_profileScreen)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}