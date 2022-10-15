package ru.geekbrains.closeapp.repository.impl

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.closeapp.core.database.UserDAO
import ru.geekbrains.closeapp.core.mapper.RepoMapper
import ru.geekbrains.closeapp.core.mapper.UserMapper
import ru.geekbrains.closeapp.core.network.UsersApi
import ru.geekbrains.closeapp.core.utils.doCompletableIf
import ru.geekbrains.closeapp.model.GithubUser
import ru.geekbrains.closeapp.repository.GithubRepository

class GithubUserRepositoryImpl constructor(
    private val usersApi: UsersApi,
    private val userDao: UserDAO,
    private val networkStatus : Single<Boolean>
) : GithubRepository {
    override fun getUsers(): Single<List<GithubUser>> {
        return fetchFromApi(true)
    }

    private fun fetchFromApi(shouldPersist: Boolean) : Single<List<GithubUser>> {
        return usersApi.getAllUsers()
            .doCompletableIf(shouldPersist) {
                userDao.insertAll(it.map(UserMapper::mapToDBObject))
            }
            .map { it.map(UserMapper::mapToEntity) }

    }

    private fun getFromDatabase() : Single<List<GithubUser>> {
        return userDao.queryForAllUsers().map { it.map(UserMapper::mapToEntity) }
    }

    override fun getUserWithRepos(login: String): Single<GithubUser> {
        return userDao.getUserWithRepos(login)
            .map { userWithRepos ->
                val user = UserMapper.mapToEntity(userWithRepos.userDBObject)
                user.repos = userWithRepos.repos.map {RepoMapper.mapToEntity(it) }
                user
            }
    }

    override fun getUser(): GithubUser {
        return GithubUser(0,"","", listOf())
    }

    override fun getUserByLogin(login: String): Single<GithubUser> {
        return usersApi.getUser(login)
            .map(UserMapper::mapToEntity)
    }
}