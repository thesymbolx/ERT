package com.example.technicaltaskert

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class FieldsViewModel : ViewModel() {

    enum class FieldType{
        VALUE,
        NUMBER,
        PRIORITY,
        DAYS,
        TIME
    }

    lateinit var onFieldClick : (FieldType) -> Unit

    var daysActive = mutableMapOf<String, Boolean>()

    val fieldType = MutableLiveData(FieldType.VALUE)
    val value = MutableLiveData<String>()
    val number = MutableLiveData<String>()
    val priority = MutableLiveData<String>()
    val time = MutableLiveData<String>()
    val days = MutableLiveData<String>()

    fun setDay(day: String, isDay: Boolean) {
        daysActive[day] = isDay
        days.value = daysActive.values.filter { it }.joinToString(",")
    }
}




