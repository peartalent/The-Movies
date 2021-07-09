package com.vietis.themovies.base.adapter

import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.vietis.themovies.base.viewholder.BaseViewHolder
import com.vietis.themovies.data.DiffEntity

abstract class BaseListAdapter<T : DiffEntity, B : ViewBinding> :
    ListAdapter<T, BaseViewHolder<T, B>>(BaseDiffUtil<T>()),
    BindableAdapter<List<T>> {

    override fun onBindViewHolder(holder: BaseViewHolder<T, B>, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun setData(data: List<T>?) {
        submitList(data)
    }
}
