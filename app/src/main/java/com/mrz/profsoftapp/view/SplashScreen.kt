package com.mrz.profsoftapp.view

import android.app.ActivityOptions
import android.os.Bundle
import android.os.Handler
import android.util.Pair
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.Navigation
import com.mrz.profsoftapp.R
import com.mrz.profsoftapp.databinding.SplashScreenBinding

class SplashScreen : Fragment() {

    private var _binding: SplashScreenBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SplashScreenBinding.inflate(inflater, container, false)
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

        binding.btnSignIn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_loginScreen_to_signinScreen, (ActivityOptions.makeSceneTransitionAnimation(
                this.activity, Pair(binding.logo, "logo")
            ).toBundle()))
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}