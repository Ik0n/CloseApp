package ru.geekbrains.closeapp.user

import android.widget.Toast
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import ru.geekbrains.closeapp.GeekBrainsApp
import ru.geekbrains.closeapp.core.nav.DetailsUserScreen
import ru.geekbrains.closeapp.model.GithubUser
import ru.geekbrains.closeapp.repository.GithubRepository
import java.util.concurrent.TimeUnit

class UserPresenter(
    private val repository : GithubRepository,
    private val router: Router
) : MvpPresenter<UserView>() {



    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLoading()
        repository.getUsers().delay(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.initList(it)
                    viewState.hideLoading()
                },
                {
                    viewState.showErrorToast()
                }
            )
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