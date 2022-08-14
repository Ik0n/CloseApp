package ru.geekbrains.closeapp.repository.impl

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.closeapp.model.GithubUser
import ru.geekbrains.closeapp.repository.GithubRepository

class GithubRepositoryImpl : GithubRepository {
    private val repositories = listOf(
        GithubUser(1,"Qwerty"),
        GithubUser(2,"Joodeg"),
        GithubUser(3,"ASckkwq"),
        GithubUser(4,"Printer"),
        GithubUser(5,"SaintPos")
    )

    override fun getUsers() : Single<List<GithubUser>> {
        return Single.create {
            it.onSuccess(repositories)
        }
    }

    override fun getUser(): GithubUser {
        return repositories[0]
    }

    override fun getUser(id: Int): GithubUser {
        return repositories[id]
    }


}