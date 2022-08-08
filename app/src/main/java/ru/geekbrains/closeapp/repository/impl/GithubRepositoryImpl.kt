package ru.geekbrains.closeapp.repository.impl

import ru.geekbrains.closeapp.model.GithubUser
import ru.geekbrains.closeapp.repository.GithubRepository

class GithubRepositoryImpl : GithubRepository {
    private val repositories = listOf(
        GithubUser("Qwerty"),
        GithubUser("Joodeg"),
        GithubUser("ASckkwq"),
        GithubUser("Printer"),
        GithubUser("SaintPos")
    )

    override fun getUsers() : List<GithubUser> {
        return repositories
    }

    override fun getUser(): GithubUser {
        return repositories[0]
    }

    override fun getUser(id: Int): GithubUser {
        return repositories[id]
    }


}