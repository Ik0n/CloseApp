package ru.geekbrains.closeapp.detailsUser

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.geekbrains.closeapp.core.utils.disposeBy
import ru.geekbrains.closeapp.core.utils.subscribeByDefault
import ru.geekbrains.closeapp.model.GithubUser
import ru.geekbrains.closeapp.repository.GithubRepository

class DetailsUserPresenter(
    private val repository: GithubRepository,
    private val router: Router
) : MvpPresenter<DetailsUserView>() {

    private val bag = CompositeDisposable()

    fun loadUser(login: String) {
        viewState.showLoading()
        repository.getUserByLogin(login)
            .subscribeByDefault()
            .subscribe(
                {
                    viewState.initUser(it)
                    viewState.hideLoading()
                }, {
                    viewState.hideLoading()
                }
            ).disposeBy(bag)
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        bag.dispose()
    }

}