package com.example.technicaltaskert

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.technicaltaskert.databinding.FragmentFieldsBinding

class FieldsFragment : Fragment() {

    private val viewModel: FieldsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {

        return FragmentFieldsBinding.inflate(inflater).apply {
            fieldViewModel = viewModel
            lifecycleOwner = this@FieldsFragment
        }.root
    }

   fun onClick() = findNavController().navigate(FieldsFragmentDirections.actionFieldsFragmentToFieldDialog())
}
