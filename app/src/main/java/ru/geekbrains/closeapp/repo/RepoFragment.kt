package ru.geekbrains.closeapp.repo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.closeapp.ARG_LOGIN
import ru.geekbrains.closeapp.ARG_REPO_NAME
import ru.geekbrains.closeapp.GeekBrainsApp
import ru.geekbrains.closeapp.core.OnBackPressedListener
import ru.geekbrains.closeapp.core.network.NetworkProvider
import ru.geekbrains.closeapp.databinding.FragmentDetailsRepoBinding
import ru.geekbrains.closeapp.databinding.FragmentDetailsUserBinding
import ru.geekbrains.closeapp.detailsUser.DetailsUserFragment
import ru.geekbrains.closeapp.detailsUser.DetailsUserPresenter
import ru.geekbrains.closeapp.model.Repo
import ru.geekbrains.closeapp.repository.impl.GithubRepoRepositoryImpl
import ru.geekbrains.closeapp.repository.impl.GithubRepositoryImpl

class RepoFragment : MvpAppCompatFragment(), RepoView, OnBackPressedListener {

    companion object {

        fun getInstance(login : String, name : String) : RepoFragment {
            return RepoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_LOGIN, login)
                    putString(ARG_REPO_NAME, name)
                }
            }
        }
    }

    private var viewBinding: FragmentDetailsRepoBinding? = null

    private val presenter : RepoPresenter by moxyPresenter {
        RepoPresenter(
            GithubRepoRepositoryImpl(NetworkProvider.reposApi),
            GeekBrainsApp.instance.router
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Toast.makeText(requireContext(), "TEST", Toast.LENGTH_SHORT).show()
        return FragmentDetailsRepoBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(ARG_LOGIN)?.let { login ->
            arguments?.getString(ARG_REPO_NAME)?.let { name ->
                presenter.loadRepo(login, name)
            }
        }
    }

    override fun onBackPressed() = presenter.onBackPressed()

    override fun initRepo(repo: Repo) {
        viewBinding?.apply {
            tvName.text = repo.name
            tvFullName.text = repo.fullName
            tvDescription.text = repo.description
        }
    }
}