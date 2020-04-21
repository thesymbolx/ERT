package com.example.technicaltaskert

import android.view.View
import androidx.databinding.BindingAdapter

class BindingAdapters {
    companion object {
        @JvmStatic
        @BindingAdapter("visibleWhile")
        open fun visibleWhile(view: View, show: Boolean): Unit {
            view.visibility = if (show) View.VISIBLE else View.GONE
        }
    }
}