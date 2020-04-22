package com.example.technicaltaskert.dialogs

import android.text.InputType
import androidx.navigation.fragment.navArgs
import com.example.technicaltaskert.R
import com.example.technicaltaskert.databinding.DialogTextFieldBinding

class TextFieldDialog : BaseFieldsDialog<DialogTextFieldBinding>() {
    enum class FieldInputType(val typeFlag : Int){
        VALUE(InputType.TYPE_CLASS_TEXT),
        QUANTITY(InputType.TYPE_CLASS_NUMBER)
    }

    private val fieldInputType : TextFieldDialogArgs by navArgs()

    override fun getLayoutId() = R.layout.dialog_text_field

    override fun configureBinding(binding: DialogTextFieldBinding) {
        if(fieldInputType.inputType == FieldInputType.QUANTITY) {
            binding.obs = viewModel.quantity
        }else{
            binding.obs = viewModel.value
        }

        binding.valueTextView.inputType = fieldInputType.inputType.typeFlag
    }
}