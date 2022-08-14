package ru.geekbrains.closeapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser (
    val id: Int,
    val login: String
) : Parcelable