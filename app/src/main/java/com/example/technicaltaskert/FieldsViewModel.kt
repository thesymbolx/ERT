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

    var daysActive = mutableMapOf<Day, Boolean>()
    val value = MutableLiveData<String>()
    val quantity = MutableLiveData<String>()
    val priority = MutableLiveData<String>()
    var hour : Int? = null
    var min : Int? = null
    val time = MutableLiveData<String>()
    val days = MutableLiveData<String>()

    fun setDay(day: Day, isDay: Boolean) {
        daysActive[day] = isDay
        days.value = daysActive
            .filter { it.value }
            .keys
            .sortedBy { it.ordinal }
            .joinToString(", ")
            { it.value }
    }
}

enum class Day(var value: String){
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday")
}




