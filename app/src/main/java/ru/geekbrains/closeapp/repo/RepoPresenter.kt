package ru.geekbrains.closeapp.repo

import android.util.Log
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.geekbrains.closeapp.core.utils.disposeBy
import ru.geekbrains.closeapp.core.utils.subscribeByDefault
import ru.geekbrains.closeapp.repository.GithubRepoRepository

class RepoPresenter(
    private val repoRepository: GithubRepoRepository,
    private val router: Router
) : MvpPresenter<RepoView>() {

    private val bag = CompositeDisposable()

    fun loadRepo(login: String, name: String) {
        repoRepository.getRepoByName(login, name)
            .subscribeByDefault()
            .subscribe(
                {
                    viewState.initRepo(it)
                },
                {
                    Log.e("EEE", it.message.toString() + " " + login + " " + name)
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