package com.example.technicaltaskert

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FieldsViewModel : ViewModel() {

    enum class FieldType{
        VALUE,
        NUMBER,
        PRIORITY,
        DAYS
    }

    lateinit var onFieldClick : (FieldType) -> Unit

    val fieldType = MutableLiveData(FieldType.VALUE)
    val value = MutableLiveData<String>()
    val number = MutableLiveData<String>()
    val priority = MutableLiveData<String>()
    val day = MutableLiveData<String>()
}