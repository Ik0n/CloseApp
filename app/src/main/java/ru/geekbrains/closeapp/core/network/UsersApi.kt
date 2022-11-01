package ru.geekbrains.closeapp.core.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import ru.geekbrains.closeapp.model.GithubUser

interface UsersApi {

    @GET("/users")
    fun getAllUsers() : Single<List<UserDto>>

    @GET("/users/{login}")
    fun getUser(@Path("login") login : String) : Single<UserDto>
}