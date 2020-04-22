package com.example.technicaltaskert.dialogs

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.content.edit
import com.example.technicaltaskert.R
import com.example.technicaltaskert.databinding.DialogPriorityBinding

class PriorityDialog : BaseFieldsDialog<DialogPriorityBinding>(), AdapterView.OnItemSelectedListener {
    override fun getLayoutId() = R.layout.dialog_priority

    override fun configureBinding(binding: DialogPriorityBinding) {
        context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.spinner_priorities,
                android.R.layout.simple_spinner_item).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.prioritySpinner.adapter = adapter
            }
        }

        //For speed. Ideally use inverse binding adapters.
        binding.prioritySpinner.onItemSelectedListener = this

        val spinnerPosition = activity?.getSharedPreferences("prefs", Context.MODE_PRIVATE)
            ?.getInt("spinner_index", 0) ?: 0

        binding.prioritySpinner.setSelection(spinnerPosition)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        parent?.getItemAtPosition(position)?.let {

            activity?.getSharedPreferences("prefs", Context.MODE_PRIVATE)
                ?.edit { putInt("spinner_index", position) }

            viewModel.priority.value = it.toString()
        }
    }
}