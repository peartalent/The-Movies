package com.vietis.themovies.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.vietis.themovies.data.DiffEntity

@Entity(tableName = "actor")
data class Actor(
    @SerializedName("cast_id")
    @PrimaryKey
    val castId: Int,
    var castMovieId: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("profile_path")
    val avatar: String
) : DiffEntity {

    override fun areItemsTheSame(newItem: DiffEntity): Boolean =
        newItem is Actor && this.castId == newItem.castId

    override fun areContentsTheSame(newItem: DiffEntity): Boolean =
        newItem is Actor && this == newItem
}
