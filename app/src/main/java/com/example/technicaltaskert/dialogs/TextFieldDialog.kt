package com.example.technicaltaskert.dialogs

import com.example.technicaltaskert.R
import com.example.technicaltaskert.databinding.DialogTextFieldBinding


class TextFieldDialog : BaseFieldsDialog<DialogTextFieldBinding>() {
    override fun getLayoutId() = R.layout.dialog_text_field
    override fun configureBinding(binding: DialogTextFieldBinding) {}
}