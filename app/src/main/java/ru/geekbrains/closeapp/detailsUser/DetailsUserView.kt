package ru.geekbrains.closeapp.detailsUser

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.geekbrains.closeapp.model.GithubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface DetailsUserView : MvpView {
    fun initUser(user: GithubUser)
}