package com.example.shoestoreapp

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.shoestoreapp.databinding.FragmentShoeListBinding
import com.example.shoestoreapp.databinding.FragmentShoeListItemBinding

public class shoe_list() : Fragment(), MenuProvider {


    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_list,container,false)

        // on floating button clicked navigate to another screen
        binding.floatBtn.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_shoe_list_to_add_shoe)
        }


        // linear layout
       val shoe_list_view = binding.linearShoeList

        viewModel.defult_value()

        viewModel.shoe_live_data.observe(viewLifecycleOwner, Observer { shoe_model_list->

            //add fragment to linear layout
            for(shoe in shoe_model_list) {

                val itemBinding: FragmentShoeListItemBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list_item,shoe_list_view,false)

                itemBinding.txCompany.text = shoe.company
                itemBinding.txDescription.text = shoe.description
                itemBinding.txName.text = shoe.name
                itemBinding.txSize.text = shoe.size

                shoe_list_view.addView(itemBinding.root)
            }
        })

        //menu option logout
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return  binding.root
    }


    // menu option create menu
    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.shoe_list_menu, menu)
    }

    //menu option item selected
    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        view?.findNavController()?.navigate(R.id.action_shoe_list_to_login)

        return  true
    }


}