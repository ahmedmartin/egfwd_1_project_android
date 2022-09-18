package com.example.shoestoreapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.shoestoreapp.databinding.FragmentWelcomeOnboardingBinding

class welcome_onboarding : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_welcome_onboarding, container, false)
        val  binding:FragmentWelcomeOnboardingBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_welcome_onboarding,container,false)

        binding.btnWelcomeNext.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_welcome_onboarding_to_instructions_onboarding)
        }

        return  binding.root
    }
}