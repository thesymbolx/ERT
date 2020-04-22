package com.example.technicaltaskert.dialogs

import android.text.InputType
import androidx.navigation.fragment.navArgs
import com.example.technicaltaskert.R
import com.example.technicaltaskert.databinding.DialogTextFieldBinding

class TextFieldDialog : BaseFieldsDialog<DialogTextFieldBinding>() {
    enum class FieldInputType(val typeFlag : Int){
        VALUE(InputType.TYPE_CLASS_TEXT),
        QUANTITY(InputType.TYPE_CLASS_NUMBER),
        EMAIL(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS)
    }

    private val fieldInputType : TextFieldDialogArgs by navArgs()

    override fun getLayoutId() = R.layout.dialog_text_field

    override fun configureBinding(binding: DialogTextFieldBinding) {
        binding.obs = when(fieldInputType.inputType){
            FieldInputType.QUANTITY -> viewModel.quantity
            FieldInputType.VALUE -> viewModel.value
            FieldInputType.EMAIL -> viewModel.email
        }

        binding.valueTextView.inputType = fieldInputType.inputType.typeFlag
    }
}