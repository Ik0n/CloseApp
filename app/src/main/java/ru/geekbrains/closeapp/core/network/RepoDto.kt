package ru.geekbrains.closeapp.core.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RepoDto(
    @Expose
    @SerializedName("id")
    val id: Long,
    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("full_name")
    val fullName: String,
    @Expose
    @SerializedName("description")
    val description: String
)