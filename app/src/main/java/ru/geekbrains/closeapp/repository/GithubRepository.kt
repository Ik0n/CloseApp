package ru.geekbrains.closeapp.repository

import ru.geekbrains.closeapp.model.GithubUser

interface GithubRepository {
    fun getUsers() : List<GithubUser>
}