package ru.geekbrains.closeapp.repository

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.closeapp.model.GithubUser

interface GithubRepository {
    fun getUsers() : Single<List<GithubUser>>
    fun getUser() : GithubUser
    fun getUserByLogin(login : String) : Single<GithubUser>
}