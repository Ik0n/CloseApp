package ru.geekbrains.closeapp.user

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.geekbrains.closeapp.model.GithubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserView : MvpView {
    fun initList(list: List<GithubUser>)
}