package com.vietis.themovies.data.model

import com.google.gson.annotations.SerializedName
import com.vietis.themovies.data.DiffEntity

data class GenreResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
) : DiffEntity {

    override fun areItemsTheSame(newItem: DiffEntity): Boolean =
        newItem is GenreResponse && this.id == newItem.id

    override fun areContentsTheSame(newItem: DiffEntity): Boolean =
        newItem is GenreResponse && this == newItem
}
