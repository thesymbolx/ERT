package com.example.technicaltaskert.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.technicaltaskert.FieldDialogArgs
import com.example.technicaltaskert.FieldsViewModel

abstract class BaseDialog<T : ViewDataBinding> : DialogFragment(){
    private val viewModel: FieldsViewModel by activityViewModels()
    private val args: FieldDialogArgs by navArgs()
    private lateinit var binding : T

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            getLayoutId(), null, false)

        return AlertDialog.Builder(activity).run {
            setView(binding.root)
            setNegativeButton("Close"){ _, _ -> dismiss() }
            create()
        }
    }

    abstract fun getLayoutId() : Int
}