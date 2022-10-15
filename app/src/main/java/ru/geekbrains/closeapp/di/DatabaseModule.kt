package ru.geekbrains.closeapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.geekbrains.closeapp.core.database.GithubAppDatabase
import ru.geekbrains.closeapp.core.database.UserDAO
import javax.inject.Singleton

@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun database(context: Context) : GithubAppDatabase = GithubAppDatabase.create(context)

    @Singleton
    @Provides
    fun userDao(database: GithubAppDatabase) : UserDAO = database.UserDao()
}