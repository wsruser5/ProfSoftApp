package com.mrz.profsoftapp.view

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.mrz.profsoftapp.R
import com.mrz.profsoftapp.databinding.FragmentLoginScreenBinding

class LoginScreen : Fragment() {

    private var _binding: FragmentLoginScreenBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginScreenBinding.inflate(inflater, container, false)
        val view = binding.root

        val animProfs = AnimationUtils.loadAnimation(context, R.anim.profs_anim)
        val animFt = AnimationUtils.loadAnimation(context, R.anim.ft_anim)
        val animSwitch = AnimationUtils.loadAnimation(context, R.anim.switcher_anim)
        val animFadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_in)

        binding.btnSignIn.visibility = View.GONE
        binding.btnSkip.visibility = View.GONE
        binding.profsText.visibility = View.INVISIBLE
        binding.ftText.visibility = View.INVISIBLE
        binding.switchButton.startAnimation(animSwitch)
        Handler().postDelayed({
            binding.profsText.visibility = View.VISIBLE
            binding.ftText.visibility = View.VISIBLE
            binding.profsText.startAnimation(animProfs)
            binding.ftText.startAnimation(animFt)
            Handler().postDelayed({
                binding.btnSignIn.startAnimation(animFadeIn)
                binding.btnSkip.startAnimation(animFadeIn)
                binding.btnSignIn.visibility = View.VISIBLE
                binding.btnSkip.visibility = View.VISIBLE
            },1000)

        },1000)

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}