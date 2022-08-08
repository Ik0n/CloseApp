package ru.geekbrains.closeapp.main

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.geekbrains.closeapp.model.GithubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : MvpView