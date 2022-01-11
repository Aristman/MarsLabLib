package ru.marslab.marslablib

import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class FragmentBindWithVM<VM : ViewModel, B : ViewBinding>(
    bindingInflater: Inflater<B>
) : FragmentBinding<B>(bindingInflater) {

    protected abstract val fragmentViewModel: VM
}
