package com.example.shoestoreapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController

class ShoeViewModel:ViewModel (){


     var name: String = ""
     var company: String =""
     var size: String =""
     var description: String =""

    private val _event_saved = MutableLiveData<Boolean>()
    val event_saved:LiveData<Boolean> get() = _event_saved

    private var shoe_list = MutableLiveData<ArrayList<ShowModel>>()
    val shoe_live_data:LiveData<ArrayList<ShowModel>> get() = shoe_list
    val initial_list = ArrayList<ShowModel> ()

    init {
        _event_saved.postValue(false)
        for (i in 1..5) {
            val model: ShowModel = ShowModel("name $i", "company $i", "$i$i", "description for shoe $i")
            initial_list.add(model)
        }
        shoe_list.postValue(initial_list)
    }

//   fun add_arguments(name:String,company:String,size:String,description:String) {
//
//       if(name.isNotEmpty()&&company.isNotEmpty()&&size.isNotEmpty()&&description.isNotEmpty()) {
//           val model: show_model = show_model(name, company, size, description)
//           initial_list.add(model)
//           shoe_list.postValue(initial_list)
//       }
//
//   }

    fun add_arguments() {
        if(name.isNotEmpty()&&company.isNotEmpty()&&size.isNotEmpty()&&description.isNotEmpty()) {
            val model: ShowModel = ShowModel(name, company, size, description)
            initial_list.add(model)
            shoe_list.postValue(initial_list)
            _event_saved.postValue(true)
        }
    }

    fun defult_value(){
        name = ""
        company=""
        size=""
        description=""

        _event_saved.postValue(false)
    }

}