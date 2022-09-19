package com.example.shoestoreapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.shoestoreapp.databinding.FragmentAddShoeBinding

class add_shoe : Fragment() {


    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_add_shoe, container, false)

        val binding: FragmentAddShoeBinding = DataBindingUtil.inflate(inflater,
        R.layout.fragment_add_shoe,container,false)

        binding.showVariable = viewModel

        // button cancel
        binding.btnCancel.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_add_shoe_to_shoe_list)
        }

        viewModel.event_saved.observe(viewLifecycleOwner, Observer { isSaved->
            if(isSaved)
                view?.findNavController()?.navigate(R.id.action_add_shoe_to_shoe_list)
        })
        //button save
//        binding.btnSave.setOnClickListener {
////            var name = binding.txFieldName.text.toString()
////            var company = binding.txFieldCompany.text.toString()
////            var size = binding.txFieldSize.text.toString()
////            var description = binding.txFieldDescription.text.toString()
////
////            viewModel.add_arguments(name, company, size, description)
//
//            view?.findNavController()?.navigate(add_shoeDirections.actionAddShoeToShoeList())
//            Log.i("test", "onCreateView: ")
//        }

       return binding.root
    }



}