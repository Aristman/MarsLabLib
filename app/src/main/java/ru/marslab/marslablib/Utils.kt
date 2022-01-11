package ru.marslab.marslablib

import android.view.LayoutInflater
import android.view.ViewGroup

typealias Inflater<B> = (LayoutInflater, ViewGroup?, Boolean) -> B

const val ERROR_INFLATE_BINDING = "Binding is not inflate"
