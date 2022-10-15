package ru.geekbrains.closeapp.di

import android.content.Context
import android.net.ConnectivityManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val applicationContext: Context) {

    @Singleton
    @Provides
    fun provideContext() : Context = applicationContext

    @Singleton
    @Provides
    fun provideConnectivityManager(): ConnectivityManager {
        return applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

}