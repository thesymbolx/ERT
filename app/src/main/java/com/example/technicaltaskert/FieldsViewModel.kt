package com.example.technicaltaskert

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FieldsViewModel : ViewModel() {
    enum class FieldType{
        VALUE,
        QUANTITY,
        PRIORITY,
        DAYS,
        TIME
    }

    lateinit var onFieldClick : (FieldType) -> Unit

    private var daysActive = mutableMapOf<String, Boolean>()
    val value = MutableLiveData<String>()
    val quantity = MutableLiveData<String>()
    val priority = MutableLiveData<String>()
    val time = MutableLiveData<String>()
    val days = MutableLiveData<String>()

    fun setDay(day: String, isDay: Boolean) {
        daysActive[day] = isDay
        days.value = daysActive.values.filter { it }.joinToString(",")
    }
}




