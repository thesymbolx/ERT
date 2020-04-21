package com.example.technicaltaskert.dialogs

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
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
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        parent?.getItemAtPosition(position)?.let {
            viewModel.priority.value = it.toString()
        }
    }
}