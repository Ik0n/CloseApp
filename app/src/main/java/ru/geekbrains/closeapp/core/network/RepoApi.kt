package ru.geekbrains.closeapp.core.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RepoApi {
    @GET("/users/{login}/repos")
    fun getUserRepos(@Path("login") login : String) : Single<List<RepoDto>>

    @GET("repos/{login}/{repo}")
    fun gerUserRepo(@Path("login") login: String, @Path("repo") repo: String) : Single<RepoDto>
}