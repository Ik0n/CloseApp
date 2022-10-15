package ru.geekbrains.closeapp.di

import dagger.Module
import dagger.Provides
import ru.geekbrains.closeapp.core.network.RepoApi
import ru.geekbrains.closeapp.repository.GithubRepoRepository
import ru.geekbrains.closeapp.repository.impl.GithubRepoRepositoryImpl
import javax.inject.Singleton

@Module
object RepositoryRepoModule {

    @Singleton
    @Provides
    fun provideRepositoryRepo(
        repoApi: RepoApi
    ) : GithubRepoRepository = GithubRepoRepositoryImpl(repoApi)
}