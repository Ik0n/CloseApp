package ru.geekbrains.closeapp.di

import dagger.Component
import ru.geekbrains.closeapp.detailsUser.DetailsUserFragment
import ru.geekbrains.closeapp.detailsUser.DetailsUserPresenter
import ru.geekbrains.closeapp.main.MainActivity
import ru.geekbrains.closeapp.main.MainPresenter
import ru.geekbrains.closeapp.repo.RepoFragment
import ru.geekbrains.closeapp.repo.RepoPresenter
import ru.geekbrains.closeapp.user.UserFragment
import ru.geekbrains.closeapp.user.UserPresenter
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ApiModule::class,
        DatabaseModule::class,
        CiceroneModule::class,
        RepoModule::class,
        RepositoryRepoModule::class,
        RepoApiModule::class
    ]
)

interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)

    fun inject(userPresenter: UserPresenter)
    fun inject(userFragment: UserFragment)

    fun inject(detailsUserFragment: DetailsUserFragment)
    fun inject(detailsUserPresenter: DetailsUserPresenter)

    fun inject(repoPresenter: RepoPresenter)
    fun inject(repoFragment: RepoFragment)

}