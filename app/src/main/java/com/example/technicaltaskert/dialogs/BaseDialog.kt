package com.example.technicaltaskert.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.technicaltaskert.BR
import com.example.technicaltaskert.FieldsViewModel

abstract class BaseFieldsDialog<T : ViewDataBinding> : DialogFragment(){
    protected val viewModel: FieldsViewModel by activityViewModels()
    protected lateinit var binding : T

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            getLayoutId(), null, false)

        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this

        configureBinding(binding)

        return AlertDialog.Builder(activity).run {
            setView(binding.root)
            setNegativeButton("Close"){ _, _ -> dismiss() }
            create()
        }
    }

    abstract fun getLayoutId() : Int
    abstract fun configureBinding(binding: T)
}