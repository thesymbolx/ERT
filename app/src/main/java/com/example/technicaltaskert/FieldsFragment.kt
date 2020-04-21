package com.example.technicaltaskert

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.technicaltaskert.databinding.FragmentFieldsBinding
import com.example.technicaltaskert.FieldsViewModel.FieldType.*

class FieldsFragment : Fragment() {

    private val viewModel: FieldsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {

        viewModel.onFieldClick = ::openFieldsDialog

        return FragmentFieldsBinding.inflate(inflater).apply {
            fieldViewModel = viewModel
            lifecycleOwner = this@FieldsFragment
        }.root
    }

   private fun openFieldsDialog(field: FieldsViewModel.FieldType) =
       when(field){
           VALUE -> findNavController().navigate(FieldsFragmentDirections.actionFieldsFragmentToFieldDialog())
           NUMBER -> findNavController().navigate(FieldsFragmentDirections.actionFieldsFragmentToFieldDialog())
           PRIORITY -> findNavController().navigate(FieldsFragmentDirections.actionFieldsFragmentToFieldDialog())
           DAYS -> findNavController().navigate(FieldsFragmentDirections.())
           TIME -> findNavController().navigate(FieldsFragmentDirections.actionFieldsFragmentToTimeDialog())
       }
}
