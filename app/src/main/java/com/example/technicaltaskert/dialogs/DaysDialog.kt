package com.example.technicaltaskert.dialogs

import com.example.technicaltaskert.R
import com.example.technicaltaskert.databinding.DialogDaysBinding

class DaysDialog : BaseFieldsDialog<DialogDaysBinding>() {
    override fun getLayoutId() = R.layout.dialog_days
    override fun configureBinding(binding: DialogDaysBinding) {}
}
