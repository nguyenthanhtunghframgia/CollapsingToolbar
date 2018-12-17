package com.example.framgianguyenthanhtungh.collapsingtoolbar.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<viewDataBinding : ViewDataBinding, viewModel : BaseViewModel> : Fragment() {
    lateinit var viewDataBinding: viewDataBinding
    abstract val viewModel: viewModel
    abstract val layoutId: Int
    abstract val bindingVariable: Int

    abstract fun initView(viewBinding: viewDataBinding)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.apply {
            setVariable(bindingVariable, viewModel)
            executePendingBindings()
            setLifecycleOwner(viewLifecycleOwner)
            initView(this)
        }
    }

    open fun onBackPressed() {
    }
}
