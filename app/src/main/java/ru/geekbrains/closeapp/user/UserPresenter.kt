package ru.geekbrains.closeapp.user

import android.widget.Toast
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
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
        repository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
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

    fun openDetailsUser(login: String) {
        router.navigateTo(DetailsUserScreen(login))
        Toast.makeText(GeekBrainsApp.instance, login, Toast.LENGTH_SHORT).show()
    }

    fun onBackPressed() : Boolean {
        router.exit()
        return true
    }

}