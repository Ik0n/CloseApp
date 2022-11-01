package ru.geekbrains.closeapp.repository.impl

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.closeapp.core.mapper.RepoMapper
import ru.geekbrains.closeapp.core.network.RepoApi
import ru.geekbrains.closeapp.model.Repo
import ru.geekbrains.closeapp.repository.GithubRepoRepository

class GithubRepoRepositoryImpl constructor(
    private val repoApi : RepoApi
) : GithubRepoRepository {
    override fun getReposByUserLogin(login: String): Single<List<Repo>> {
        return repoApi.getUserRepos(login)
            .map { it.map(RepoMapper::mapToEntity) }
    }

    override fun getRepoByName(login: String, name: String): Single<Repo> {
        return repoApi.gerUserRepo(login, name)
            .map(RepoMapper::mapToEntity)
    }
}