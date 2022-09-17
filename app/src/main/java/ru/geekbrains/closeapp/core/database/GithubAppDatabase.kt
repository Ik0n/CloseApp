package ru.geekbrains.closeapp.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [UserDBObject::class, RepoDBObject::class],
    version = 1
)
abstract class GithubAppDatabase : RoomDatabase() {

    abstract fun UserDao(): UserDAO
    companion object {
        fun create(context: Context) : GithubAppDatabase {
            return Room.databaseBuilder(
                context,
                GithubAppDatabase::class.java,
                "github.database"
            ).build()
        }
    }

}