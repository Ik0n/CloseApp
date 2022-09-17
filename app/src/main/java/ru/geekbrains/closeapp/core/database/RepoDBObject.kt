package ru.geekbrains.closeapp.core.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "repos")
data class RepoDBObject(
    @PrimaryKey
    @ColumnInfo(name = PRIMARY_KEY)
    val id: Long,
    val name: String,
    val fullName: String,
    val description: String,
    @ColumnInfo(name = FOREIGN_USER_KEY)
    val userId: Long
) {
    companion object {
        const val PRIMARY_KEY = "id"
        const val FOREIGN_USER_KEY = "userId"
    }
}