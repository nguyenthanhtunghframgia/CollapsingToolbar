package com.example.framgianguyenthanhtungh.collapsingtoolbar.base

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import java.util.concurrent.Executors

abstract class BaseRecyclerAdapter<T>(callback: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, BaseViewHolder<ViewDataBinding>>(
        AsyncDifferConfig.Builder<T>(callback)
            .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
            .build()
    ) {

    protected abstract fun createBinding(parent: ViewGroup, viewType: Int? = 0): ViewDataBinding

    protected abstract fun bind(binding: ViewDataBinding, item: T)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ViewDataBinding> {
        return BaseViewHolder(createBinding(parent = parent, viewType = viewType))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ViewDataBinding>, position: Int) {
        bind(holder.binding, getItem(position))
        holder.binding.executePendingBindings()
    }
}
