package ru.geekbrains.closeapp.main

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.closeapp.core.nav.UsersScreen
import javax.inject.Inject

class MainPresenter() : MvpPresenter<MainView>() {

    @Inject lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(UsersScreen)
    }

    fun onBackPressed() {
        router.exit()
    }

}