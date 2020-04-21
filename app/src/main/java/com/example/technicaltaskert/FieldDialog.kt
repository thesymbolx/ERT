package com.example.technicaltaskert

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.technicaltaskert.databinding.FragmentFieldDialogBinding

class FieldDialog : DialogFragment() {

    private val viewModel: FieldsViewModel by activityViewModels()
    private val args: FieldDialogArgs by navArgs()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding: FragmentFieldDialogBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.fragment_field_dialog, null, false)

        binding.fieldViewModel = viewModel
        viewModel.fieldType.value = args.fieldType

        context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.spinner_priorities,
                android.R.layout.simple_spinner_item).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                 binding.prioritySpinner.adapter = adapter
            }
        }

        return AlertDialog.Builder(activity).run {
            setView(binding.root)
            setNegativeButton("Close"){ _, _ -> dismiss() }
            create()
        }
    }
}
