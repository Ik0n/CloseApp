package ru.geekbrains.closeapp.main

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.closeapp.core.nav.UsersScreen
import ru.geekbrains.closeapp.repository.GithubRepository

class MainPresenter(
    private val router: Router
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(UsersScreen)
    }

    fun onBackPressed() {
        router.exit()
    }

}