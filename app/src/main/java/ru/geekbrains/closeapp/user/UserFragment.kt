package ru.geekbrains.closeapp.user

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.closeapp.GeekBrainsApp
import ru.geekbrains.closeapp.core.OnBackPressedListener
import ru.geekbrains.closeapp.databinding.FragmentUserListBinding
import ru.geekbrains.closeapp.main.UserAdapter
import ru.geekbrains.closeapp.model.GithubUser
import ru.geekbrains.closeapp.repository.impl.GithubRepositoryImpl

class UserFragment : MvpAppCompatFragment(), UserView, OnBackPressedListener {

    companion object {
        fun getInstance() : UserFragment {
            return UserFragment()
        }
    }
    private lateinit var viewBinding: FragmentUserListBinding

    private val presenter : UserPresenter by moxyPresenter {
        UserPresenter(GithubRepositoryImpl(), GeekBrainsApp.instance.router)
    }

    private val adapter = UserAdapter(object : UserAdapter.OnItemViewClick {
        override fun onItemViewClick(user: GithubUser) {
            presenter.openDetailsUser(user)
        }
    })



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentUserListBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {
            this.rvGithubUsers.layoutManager = LinearLayoutManager(requireContext())
            this.rvGithubUsers.adapter = adapter
        }
    }

    override fun initList(list: List<GithubUser>) {
        adapter.users = list
    }

    override fun onBackPressed() = presenter.onBackPressed()

}