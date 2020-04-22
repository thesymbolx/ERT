package com.example.technicaltaskert

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.JsonObject

class FieldsViewModel : ViewModel() {
    enum class FieldType{
        VALUE,
        QUANTITY,
        PRIORITY,
        DAYS,
        TIME,
        EMAIL
    }

    lateinit var onFieldClick : (FieldType) -> Unit
    lateinit var onEmailClicked : (String) -> Unit

    var daysActive = mutableMapOf<Day, Boolean>()
    val value = MutableLiveData<String>()
    val quantity = MutableLiveData<String>()
    val priority = MutableLiveData<String>()
    var hour : Int? = null
    var min : Int? = null
    val time = MutableLiveData<String>()
    val days = MutableLiveData<String>()
    val email = MutableLiveData<String>()

    init {
        Day.values().forEach {
            daysActive[it] = false
        }
    }

    fun setDay(day: Day, isDay: Boolean) {
        daysActive[day] = isDay
        days.value = daysActive
            .filter { it.value }
            .keys
            .sortedBy { it.ordinal }
            .joinToString(", ")
            { it.value }
    }

    fun getAsJson() : String {
        var map =
            mutableMapOf<String, Any?>(
                "value" to value.value,
                "quantity" to quantity.value,
                "priority" to priority.value,
                "time" to time.value)


        daysActive.forEach { (day, isActive) ->
            map[day.value] = isActive
        }

        return Gson().toJson(map)
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




