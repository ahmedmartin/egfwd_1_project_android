package com.example.shoestoreapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.shoestoreapp.databinding.FragmentShoeListItemBinding

class shoe_list_item(ShowModel: ShowModel) : Fragment() {

    lateinit var  Show_model: ShowModel

    init {
      Show_model = ShowModel
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding:FragmentShoeListItemBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list_item,container,false)

        binding.txCompany.text = Show_model.company
        binding.txDescription.text = Show_model.description
        binding.txName.text = Show_model.name
        binding.txSize.text = Show_model.size

       return binding.root
    }

}