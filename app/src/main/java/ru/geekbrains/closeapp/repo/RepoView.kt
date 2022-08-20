package ru.geekbrains.closeapp.repo

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.geekbrains.closeapp.model.Repo

@StateStrategyType(AddToEndSingleStrategy::class)
interface RepoView : MvpView {
    fun initRepo(repo : Repo)
}