package ru.geekbrains.closeapp.core.nav

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.geekbrains.closeapp.detailsUser.DetailsUserFragment
import ru.geekbrains.closeapp.repo.RepoFragment
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

data class RepoScreen(private val login: String, private val name: String) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return RepoFragment.getInstance(login, name)
    }
}