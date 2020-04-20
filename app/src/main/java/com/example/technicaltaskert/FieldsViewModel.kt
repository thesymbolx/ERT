package com.example.technicaltaskert

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FieldsViewModel : ViewModel() {

    val value = MutableLiveData<String>()

}