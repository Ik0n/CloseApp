package ru.geekbrains.closeapp.detailsUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.terrakok.cicerone.Router
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.closeapp.GITHUB_USER
import ru.geekbrains.closeapp.GeekBrainsApp
import ru.geekbrains.closeapp.core.OnBackPressedListener
import ru.geekbrains.closeapp.databinding.FragmentDetailsUserBinding
import ru.geekbrains.closeapp.databinding.FragmentUserListBinding
import ru.geekbrains.closeapp.model.GithubUser
import ru.geekbrains.closeapp.repository.impl.GithubRepositoryImpl
import ru.geekbrains.closeapp.user.UserFragment
import ru.geekbrains.closeapp.user.UserPresenter

class DetailsUserFragment : MvpAppCompatFragment(), DetailsUserView, OnBackPressedListener {

    companion object {
        fun getInstance(bundle: Bundle) : DetailsUserFragment {
            return DetailsUserFragment().apply {
                arguments = bundle
            }
        }
    }

    private lateinit var viewBinding: FragmentDetailsUserBinding
    private lateinit var githubUser: GithubUser

    private val presenter : DetailsUserPresenter by moxyPresenter {
        DetailsUserPresenter(GithubRepositoryImpl(), GeekBrainsApp.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentDetailsUserBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        githubUser = arguments?.getParcelable<GithubUser>(GITHUB_USER) ?: GithubUser("error")
    }

    override fun initUser(user: GithubUser) {
        with(viewBinding) {
            tvUserLogin.text = githubUser.login
        }
    }

    override fun onBackPressed() = presenter.onBackPressed()

}