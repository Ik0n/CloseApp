package ru.geekbrains.closeapp.di

import dagger.Module
import dagger.Provides
import ru.geekbrains.closeapp.core.database.UserDAO
import ru.geekbrains.closeapp.core.network.UsersApi
import ru.geekbrains.closeapp.core.utils.ConnectivityListener
import ru.geekbrains.closeapp.repository.GithubRepository
import ru.geekbrains.closeapp.repository.impl.GithubUserRepositoryImpl
import javax.inject.Singleton

@Module
object RepoModule {

    @Singleton
    @Provides
    fun provideUserRepo(
        usersApi: UsersApi,
        userDao: UserDAO,
        networkStatus : ConnectivityListener,
    ) : GithubRepository = GithubUserRepositoryImpl(usersApi, userDao, networkStatus.statusSingle())

}