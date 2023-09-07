package com.fikrisandi.model.remote.pokemon

import com.fikrisandi.model.remote.base.BaseResponse
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PokemonListResponse(
    @SerializedName("results")
    @Expose
    var results: List<Pokemon> = listOf(),
) : BaseResponse()

data class Pokemon(
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("url")
    @Expose
    var url: String,
)

