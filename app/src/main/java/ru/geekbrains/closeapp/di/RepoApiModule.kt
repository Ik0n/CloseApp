package ru.geekbrains.closeapp.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.geekbrains.closeapp.core.network.RepoApi
import javax.inject.Named

@Module
object RepoApiModule {

    @Named("baseRepoUrl")
    @Provides
    fun provideBaseUrl(): String = "https://api.github.com/"

    @Provides
    fun provideApi(@Named("baseRepoUrl") baseUrl: String, gson: Gson) : RepoApi =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(RepoApi::class.java)

}