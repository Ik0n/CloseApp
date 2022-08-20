package ru.geekbrains.closeapp.core.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkProvider {
    private const val SERVER_URL = "https://api.github.com/"
    val usersApi by lazy {
        createRetrofit().create(UsersApi::class.java)
    }
    val reposApi by lazy {
        createRetrofit().create(RepoApi::class.java)
    }

    private fun createGsonFactory() = GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create()

    private fun createRetrofit() = Retrofit.Builder()
        .client(createClient())
        .baseUrl(SERVER_URL)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(createGsonFactory()))
        .build()

    private fun createClient() = OkHttpClient.Builder()
        .build()
}