package com.example.technicaltaskert

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.technicaltaskert.databinding.FragmentFieldDialogBinding

class FieldDialog : DialogFragment() {

    private val viewModel: FieldsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return FragmentFieldDialogBinding.inflate(inflater).apply {
            fieldViewModel = viewModel
        }.root
    }
}
