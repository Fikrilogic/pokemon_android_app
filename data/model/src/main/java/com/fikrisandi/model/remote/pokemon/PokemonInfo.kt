package com.fikrisandi.model.remote.pokemon


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

data class PokemonInfo(
    @SerializedName("abilities")
    @Expose
    var abilities: List<Ability> = listOf(),
    @SerializedName("base_experience")
    @Expose
    var baseExperience: Int = 0,
    @SerializedName("height")
    @Expose
    var height: Int = 0,
    @SerializedName("id")
    @Expose
    var id: Int = 0,
    @SerializedName("is_default")
    @Expose
    var isDefault: Boolean = false,
    @SerializedName("location_area_encounters")
    @Expose
    var locationAreaEncounters: String = "",
    @SerializedName("name")
    @Expose
    var name: String = "",
    @SerializedName("order")
    @Expose
    var order: Int = 0,
    @SerializedName("species")
    @Expose
    var species: Species = Species(),
    @SerializedName("sprites")
    @Expose
    var sprites: Sprites = Sprites(),
    @SerializedName("stats")
    @Expose
    var stats: List<Stat> = listOf(),
    @SerializedName("types")
    @Expose
    var types: List<Type> = listOf(),
    @SerializedName("weight")
    @Expose
    var weight: Int = 0
) {

    @Parcelize
    data class Ability(
        @SerializedName("ability")
        @Expose
        var ability: Ability = Ability(),
        @SerializedName("is_hidden")
        @Expose
        var isHidden: Boolean = false,
        @SerializedName("slot")
        @Expose
        var slot: Int = 0
    ): Parcelable {

        @Parcelize
        data class Ability(
            @SerializedName("name")
            @Expose
            var name: String = "",
            @SerializedName("url")
            @Expose
            var url: String = ""
        ): Parcelable
    }


    @Parcelize
    data class Species(
        @SerializedName("name")
        @Expose
        var name: String = "",
        @SerializedName("url")
        @Expose
        var url: String = ""
    ): Parcelable

    @Parcelize
    data class Sprites(
        @SerializedName("back_default")
        @Expose
        var backDefault: String = "",
        @SerializedName("back_female")
        @Expose
        var backFemale: String = "",
        @SerializedName("back_shiny")
        @Expose
        var backShiny: String = "",
        @SerializedName("back_shiny_female")
        @Expose
        var backShinyFemale: String = "",
        @SerializedName("front_default")
        @Expose
        var frontDefault: String = "",
        @SerializedName("front_female")
        @Expose
        var frontFemale: String = "",
        @SerializedName("front_shiny")
        @Expose
        var frontShiny: String = "",
        @SerializedName("front_shiny_female")
        @Expose
        var frontShinyFemale: String = "",
    ): Parcelable

    @Parcelize
    data class Stat(
        @SerializedName("base_stat")
        @Expose
        var baseStat: Int = 0,
        @SerializedName("effort")
        @Expose
        var effort: Int = 0,
        @SerializedName("stat")
        @Expose
        var stat: Stat = Stat()
    ): Parcelable {
        @Parcelize
        data class Stat(
            @SerializedName("name")
            @Expose
            var name: String = "",
            @SerializedName("url")
            @Expose
            var url: String = ""
        ): Parcelable
    }

    @Parcelize
    data class Type(
        @SerializedName("slot")
        @Expose
        var slot: Int = 0,
        @SerializedName("type")
        @Expose
        var type: Type = Type()
    ): Parcelable {

        @Parcelize
        data class Type(
            @SerializedName("name")
            @Expose
            var name: String = "",
            @SerializedName("url")
            @Expose
            var url: String = ""
        ): Parcelable
    }
}