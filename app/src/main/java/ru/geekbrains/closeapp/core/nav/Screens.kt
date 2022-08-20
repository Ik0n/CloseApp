package ru.geekbrains.closeapp.core.nav

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.geekbrains.closeapp.GITHUB_USER
import ru.geekbrains.closeapp.detailsUser.DetailsUserFragment
import ru.geekbrains.closeapp.model.GithubUser
import ru.geekbrains.closeapp.user.UserFragment

object UsersScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserFragment.getInstance()
    }
}

data class DetailsUserScreen(private val login: String) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return DetailsUserFragment.getInstance(login)
    }
}