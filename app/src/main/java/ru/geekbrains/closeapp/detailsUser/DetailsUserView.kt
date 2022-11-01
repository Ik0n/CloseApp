package ru.geekbrains.closeapp.detailsUser

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.geekbrains.closeapp.model.GithubUser
import ru.geekbrains.closeapp.model.Repo

@StateStrategyType(AddToEndSingleStrategy::class)
interface DetailsUserView : MvpView {
    fun initUser(user: GithubUser)
    fun initRepos(list: List<Repo>)
    fun showLoading()
    fun hideLoading()
}