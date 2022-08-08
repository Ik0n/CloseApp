package ru.geekbrains.closeapp.detailsUser

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.closeapp.repository.GithubRepository

class DetailsUserPresenter(
    private val repository : GithubRepository,
    private val router: Router
) : MvpPresenter<DetailsUserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initUser(repository.getUser())
    }

    fun onBackPressed() : Boolean {
        router.exit()
        return true
    }

}