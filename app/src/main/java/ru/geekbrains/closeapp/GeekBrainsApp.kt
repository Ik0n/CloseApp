package ru.geekbrains.closeapp

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import ru.geekbrains.closeapp.core.database.GithubAppDatabase
import ru.geekbrains.closeapp.core.utils.ConnectivityListener
import ru.geekbrains.closeapp.di.*

class GeekBrainsApp : Application() {

    companion object {
        lateinit var instance : GeekBrainsApp
    }

    lateinit var appComponent : AppComponent

    val database by lazy {
        GithubAppDatabase.create(this)
    }

    private lateinit var connectivityListener: ConnectivityListener

    override fun onCreate() {
        super.onCreate()
        instance = this

        connectivityListener = ConnectivityListener(
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        )

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .apiModule(ApiModule)
            .repoApiModule(RepoApiModule)
            .databaseModule(DatabaseModule)
            .ciceroneModule(CiceroneModule)
            .repoModule(RepoModule)
            .repositoryRepoModule(RepositoryRepoModule)
            .build()
    }

}