package ru.geekbrains.closeapp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser (
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("login")
    val login: String,
    @Expose
    @SerializedName("avatar_url")
    val avatarUrl: String
) : Parcelable