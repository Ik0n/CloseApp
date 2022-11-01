package ru.geekbrains.closeapp.core.mapper

import ru.geekbrains.closeapp.core.network.UserDto
import ru.geekbrains.closeapp.model.GithubUser

object UserMapper {

    fun mapToEntity(dto: UserDto) : GithubUser {
        return GithubUser(
            id = dto.id,
            login = dto.login,
            avatarUrl = dto.avatarUrl
        )
    }
}