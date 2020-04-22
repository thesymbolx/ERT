package com.example.technicaltaskert.dialogs

import com.example.technicaltaskert.Day.*
import com.example.technicaltaskert.R
import com.example.technicaltaskert.databinding.DialogDaysBinding

class DaysDialog : BaseFieldsDialog<DialogDaysBinding>() {
    override fun getLayoutId() = R.layout.dialog_days

    override fun configureBinding(binding: DialogDaysBinding) {
        viewModel.daysActive.forEach { (day, isActive) ->
            when(day){
                MONDAY -> binding.mondayCheckBox.isChecked = isActive
                TUESDAY -> binding.tuesdayCheckBox.isChecked = isActive
                WEDNESDAY -> binding.wednesdayCheckBox.isChecked = isActive
                THURSDAY -> binding.thursdayCheckBox.isChecked = isActive
                FRIDAY -> binding.fridayCheckBox.isChecked = isActive
                SATURDAY -> binding.saturdayCheckBox.isChecked = isActive
                SUNDAY -> binding.sundayCheckBox.isChecked = isActive
            }
        }
    }
}
