package com.vietis.themovies.data

interface DiffEntity {
    fun areItemsTheSame(newItem: DiffEntity): Boolean
    fun areContentsTheSame(newItem: DiffEntity): Boolean
}