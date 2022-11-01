package ru.geekbrains.closeapp.repository

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.closeapp.model.Repo

interface GithubRepoRepository {
    fun getReposByUserLogin(login : String) : Single<List<Repo>>
    fun getRepoByName(login: String, name: String) : Single<Repo>
}