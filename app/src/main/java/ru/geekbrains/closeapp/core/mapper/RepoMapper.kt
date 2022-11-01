package ru.geekbrains.closeapp.core.mapper

import ru.geekbrains.closeapp.core.network.RepoDto
import ru.geekbrains.closeapp.model.GithubUser
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

}