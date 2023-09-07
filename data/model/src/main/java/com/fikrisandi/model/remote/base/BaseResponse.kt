package com.fikrisandi.model.remote.base


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

open class BaseResponse(
    @SerializedName("count")
    @Expose
    var count: Int = 0,
    @SerializedName("next")
    @Expose
    var next: String = "",
    @SerializedName("previous")
    @Expose
    var previous: String = "",
)