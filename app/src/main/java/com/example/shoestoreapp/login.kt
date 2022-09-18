package com.example.shoestoreapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestoreapp.databinding.FragmentLoginBinding

class login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false)
        val binding:FragmentLoginBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)

        binding.btnCreate.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_login_to_welcome_onboarding)
        }

        binding.btnLogin.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_login_to_welcome_onboarding)
        }

        return  binding.root
    }
}