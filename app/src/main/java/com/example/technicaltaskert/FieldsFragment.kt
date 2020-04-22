package com.example.technicaltaskert

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.technicaltaskert.FieldsViewModel.FieldType.*
import com.example.technicaltaskert.databinding.FragmentFieldsBinding
import com.example.technicaltaskert.dialogs.TextFieldDialog


class FieldsFragment : Fragment() {
    private val viewModel: FieldsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {

        viewModel.onFieldClick = ::openFieldsDialog
        viewModel.onEmailClicked = ::sendEmail

        return FragmentFieldsBinding.inflate(inflater).apply {
            fieldViewModel = viewModel
            lifecycleOwner = this@FieldsFragment
        }.root
    }

   private fun openFieldsDialog(field: FieldsViewModel.FieldType) =
       findNavController().navigate(
           when(field){
               VALUE -> FieldsFragmentDirections.actionFieldsFragmentToTextFieldDialog(TextFieldDialog.FieldInputType.VALUE)
               QUANTITY -> FieldsFragmentDirections.actionFieldsFragmentToTextFieldDialog(TextFieldDialog.FieldInputType.QUANTITY)
               PRIORITY -> FieldsFragmentDirections.actionFieldsFragmentToPriorityDialog()
               DAYS -> FieldsFragmentDirections.actionFieldsFragmentToDaysDialog()
               TIME -> FieldsFragmentDirections.actionFieldsFragmentToTimeDialog()
               EMAIL -> FieldsFragmentDirections.actionFieldsFragmentToTextFieldDialog(TextFieldDialog.FieldInputType.EMAIL)
           })

    private fun sendEmail(message: String){
        var emailAddress = viewModel.email.value ?: ""

        val emailIntent = Intent(
            Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", emailAddress, null
            )
        ).apply {
            putExtra(Intent.EXTRA_SUBJECT, "Fields Data")
            putExtra(Intent.EXTRA_TEXT, message)
        }

        startActivity(Intent.createChooser(emailIntent, null))
    }
}
