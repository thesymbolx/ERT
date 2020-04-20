package com.example.technicaltaskert

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FieldsViewModel : ViewModel() {

    enum class FieldType{
        VALUE
    }

    val fieldType = MutableLiveData<FieldType>()
    val value = MutableLiveData<String>()

}