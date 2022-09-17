package ru.geekbrains.closeapp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import ru.geekbrains.closeapp.core.database.RepoDBObject
import ru.geekbrains.closeapp.core.network.RepoDto

@Parcelize
data class GithubUser (
    @Expose
    @SerializedName("id")
    val id: Long,
    @Expose
    @SerializedName("login")
    val login: String,
    @Expose
    @SerializedName("avatar_url")
    val avatarUrl: String?,
    var repos: List<Repo>?
) : Parcelable