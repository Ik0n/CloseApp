package ru.geekbrains.closeapp.detailsUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.closeapp.GITHUB_USER
import ru.geekbrains.closeapp.GeekBrainsApp
import ru.geekbrains.closeapp.core.OnBackPressedListener
import ru.geekbrains.closeapp.core.network.NetworkProvider
import ru.geekbrains.closeapp.core.network.UsersApi
import ru.geekbrains.closeapp.core.utils.loadImage
import ru.geekbrains.closeapp.core.utils.makeGone
import ru.geekbrains.closeapp.core.utils.makeVisible
import ru.geekbrains.closeapp.databinding.FragmentDetailsUserBinding
import ru.geekbrains.closeapp.model.GithubUser
import ru.geekbrains.closeapp.repository.impl.GithubRepositoryImpl


class DetailsUserFragment : MvpAppCompatFragment(), DetailsUserView, OnBackPressedListener {

    companion object {
        private const val ARG_LOGIN = "ARG_LOGIN"

        fun getInstance(login : String) : DetailsUserFragment {
            return DetailsUserFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_LOGIN, login)
                }
            }
        }
    }

    private var viewBinding: FragmentDetailsUserBinding? = null

    private val presenter : DetailsUserPresenter by moxyPresenter {
        DetailsUserPresenter(
            GithubRepositoryImpl(NetworkProvider.usersApi),
            GeekBrainsApp.instance.router
        )
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
        arguments?.getString(ARG_LOGIN)?.let {
            presenter.loadUser(it)
        }
    }

    override fun initUser(user: GithubUser) {
        viewBinding?.apply {
            tvUserLogin.text = user.login
            ivUserAvatar.loadImage(user.avatarUrl)
        }
    }

    override fun showLoading() {
        viewBinding?.apply {
            tvUserLogin.makeGone()
            ivUserAvatar.makeGone()
            progress.makeVisible()
        }
    }

    override fun hideLoading() {
        viewBinding?.apply {
            tvUserLogin.makeVisible()
            ivUserAvatar.makeVisible()
            progress.makeGone()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    override fun onBackPressed() = presenter.onBackPressed()

}