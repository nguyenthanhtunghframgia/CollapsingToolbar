package com.example.framgianguyenthanhtungh.collapsingtoolbar.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.framgianguyenthanhtungh.collapsingtoolbar.R

abstract class BaseActivity<viewDataBinding : ViewDataBinding, viewModel : BaseViewModel> : AppCompatActivity() {
    abstract val viewModel: viewModel
    abstract var bindingVariable: Int
    lateinit var viewDataBinding: viewDataBinding

    abstract fun layoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, layoutId())
        viewDataBinding.apply {
            setVariable(bindingVariable, viewModel)
            setLifecycleOwner(this@BaseActivity)
            executePendingBindings()
            initComponent(savedInstanceState, this)
        }
    }

    abstract fun initComponent(savedInstanceState: Bundle?, viewDataBinding: viewDataBinding)

    override fun onBackPressed() {
        ((supportFragmentManager.findFragmentById(R.id.container)) as BaseFragment<*, *>).onBackPressed()
        super.onBackPressed()
    }
}
