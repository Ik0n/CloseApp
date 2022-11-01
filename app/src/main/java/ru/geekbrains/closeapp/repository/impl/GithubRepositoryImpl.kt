package ru.geekbrains.closeapp.repository.impl

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.closeapp.core.mapper.UserMapper
import ru.geekbrains.closeapp.core.network.UsersApi
import ru.geekbrains.closeapp.model.GithubUser
import ru.geekbrains.closeapp.repository.GithubRepository

class GithubRepositoryImpl constructor(
    private val usersApi: UsersApi
) : GithubRepository {
    override fun getUsers(): Single<List<GithubUser>> {
        return usersApi.getAllUsers()
            .map { it.map(UserMapper::mapToEntity) }
    }

    override fun getUser(): GithubUser {
        return GithubUser(0,"","")
    }

    override fun getUserByLogin(login: String): Single<GithubUser> {
        return usersApi.getUser(login)
            .map(UserMapper::mapToEntity)
    }
}