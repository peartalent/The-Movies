package com.sun.homecinema.base

import androidx.recyclerview.widget.DiffUtil
import com.vietis.themovies.data.DiffEntity

class BaseDiffUtil<T : DiffEntity> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.areItemsTheSame(newItem)
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.areContentsTheSame(newItem)
    }
}
