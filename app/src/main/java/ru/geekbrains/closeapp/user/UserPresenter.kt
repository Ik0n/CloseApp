package ru.geekbrains.closeapp.user

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.closeapp.main.MainView
import ru.geekbrains.closeapp.repository.GithubRepository

class UserPresenter(
    private val repository : GithubRepository,
    private val router: Router
) : MvpPresenter<UserView>() {



    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(repository.getUsers())
    }

    fun onBackPressed() : Boolean {
        router.exit()
        return true
    }

}