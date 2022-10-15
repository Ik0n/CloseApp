package ru.geekbrains.closeapp.core.mapper

import ru.geekbrains.closeapp.core.database.RepoDBObject
import ru.geekbrains.closeapp.core.network.RepoDto
import ru.geekbrains.closeapp.model.Repo

object RepoMapper {

    fun mapToEntity(dto: RepoDto) : Repo {
        return Repo(
            id = dto.id,
            name = dto.name,
            fullName = dto.fullName,
            description = dto.description
        )
    }

    fun mapToEntity(dbObject: RepoDBObject) : Repo {
        return Repo(
            id = dbObject.id,
            name = dbObject.name,
            fullName = dbObject.fullName,
            description = dbObject.description
        )
    }

}