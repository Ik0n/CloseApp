package ru.geekbrains.closeapp.core.mapper

import ru.geekbrains.closeapp.core.database.UserDBObject
import ru.geekbrains.closeapp.core.network.UserDto
import ru.geekbrains.closeapp.model.GithubUser

object UserMapper {

    fun mapToEntity(dto: UserDto) : GithubUser {
        return GithubUser(
            id = dto.id,
            login = dto.login,
            avatarUrl = dto.avatarUrl,
            repos = listOf()
        )
    }

    fun mapToEntity(dbObject: UserDBObject) : GithubUser {
        return GithubUser(
            id = dbObject.id,
            login = dbObject.login,
            avatarUrl = dbObject.avatarUrl,
            repos = listOf()
        )
    }

    fun mapToDBObject(dto: UserDto) : UserDBObject {
        return UserDBObject(
            id = dto.id,
            login = dto.login,
            avatarUrl = dto.avatarUrl
        )
    }
}