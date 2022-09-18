package com.example.shoestoreapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestoreapp.databinding.FragmentInstructionsOnboardingBinding

class instructions_onboarding : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_instructions_onboarding, container, false)

        val binding : FragmentInstructionsOnboardingBinding =
            DataBindingUtil.inflate(inflater,R.layout.fragment_instructions_onboarding,container,false)

        binding.btnInstractionNext.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_instructions_onboarding_to_shoe_list)
        }

        return binding.root
    }
}