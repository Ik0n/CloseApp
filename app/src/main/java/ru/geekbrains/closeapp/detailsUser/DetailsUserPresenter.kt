package ru.geekbrains.closeapp.detailsUser

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.geekbrains.closeapp.core.nav.RepoScreen
import ru.geekbrains.closeapp.core.utils.disposeBy
import ru.geekbrains.closeapp.core.utils.subscribeByDefault
import ru.geekbrains.closeapp.repository.GithubRepoRepository
import ru.geekbrains.closeapp.repository.GithubRepository

class DetailsUserPresenter(
    private val githubRepository: GithubRepository,
    private val repoRepository: GithubRepoRepository,
    private val router: Router
) : MvpPresenter<DetailsUserView>() {

    private val bag = CompositeDisposable()

    fun loadUser(login: String) {
        viewState.showLoading()
        githubRepository.getUserByLogin(login)
            .subscribeByDefault()
            .subscribe(
                {
                    viewState.initUser(it)
                    viewState.hideLoading()
                }, {
                    viewState.hideLoading()
                }
            ).disposeBy(bag)
        repoRepository.getReposByUserLogin(login)
            .subscribeByDefault()
            .subscribe(
                {
                    viewState.initRepos(it)
                },
                {

                }
            )
    }

    fun openRepo(login: String, name: String) {
        router.navigateTo(RepoScreen(login, name))
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