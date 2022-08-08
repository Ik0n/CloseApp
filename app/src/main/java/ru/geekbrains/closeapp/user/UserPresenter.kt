package ru.geekbrains.closeapp.user

import android.widget.Toast
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.closeapp.GeekBrainsApp
import ru.geekbrains.closeapp.core.nav.DetailsUserScreen
import ru.geekbrains.closeapp.model.GithubUser
import ru.geekbrains.closeapp.repository.GithubRepository

class UserPresenter(
    private val repository : GithubRepository,
    private val router: Router
) : MvpPresenter<UserView>() {



    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(repository.getUsers())
    }

    fun openDetailsUser(user: GithubUser) {
        router.navigateTo(DetailsUserScreen(user))
        Toast.makeText(GeekBrainsApp.instance, user.login, Toast.LENGTH_SHORT).show()
    }

    fun onBackPressed() : Boolean {
        router.exit()
        return true
    }

}