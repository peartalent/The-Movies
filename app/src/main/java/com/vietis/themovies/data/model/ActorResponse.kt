package com.vietis.themovies.data.model

import com.google.gson.annotations.SerializedName

data class ActorResponse(
    @SerializedName("cast")
    val cast: List<Actor>
)
