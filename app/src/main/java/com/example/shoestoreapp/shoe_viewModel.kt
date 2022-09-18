package com.example.shoestoreapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class shoe_viewModel:ViewModel (){

    private var shoe_list = MutableLiveData<ArrayList<show_model>>()
    val shoe_live_data:LiveData<ArrayList<show_model>> get() = shoe_list
    val initial_list = ArrayList<show_model> ()

    init {
        for (i in 1..5) {
            Log.i("test", "$i")
            val model: show_model = show_model("name $i", "company $i", "$i$i", "description for shoe $i")
            initial_list.add(model)
        }

        shoe_list.postValue(initial_list)

        Log.i("test", "in init shoe list view")
    }

   fun add_arguments(name:String,company:String,size:String,description:String) {

       if(name.isNotEmpty()&&company.isNotEmpty()&&size.isNotEmpty()&&description.isNotEmpty()) {
           val model: show_model = show_model(name, company, size, description)
           initial_list.add(model)
           shoe_list.postValue(initial_list)
       }

   }

}