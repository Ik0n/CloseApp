package ru.geekbrains.closeapp.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.closeapp.GeekBrainsApp
import ru.geekbrains.closeapp.core.OnBackPressedListener
import ru.geekbrains.closeapp.core.utils.makeGone
import ru.geekbrains.closeapp.core.utils.makeVisible
import ru.geekbrains.closeapp.databinding.FragmentUserListBinding
import ru.geekbrains.closeapp.model.GithubUser

class UserFragment : MvpAppCompatFragment(), UserView, OnBackPressedListener {

    companion object {
        fun getInstance() : UserFragment {
            return UserFragment()
        }
    }
    private lateinit var viewBinding: FragmentUserListBinding

    private val presenter : UserPresenter by moxyPresenter {
        UserPresenter().apply {
            GeekBrainsApp.instance.appComponent.inject(this)
        }
    }
    private val adapter : UserAdapter by lazy {
        UserAdapter(presenter::openDetailsUser)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        GeekBrainsApp.instance.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

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

    override fun showLoading() = with(viewBinding) {
        pbLoading.makeVisible()
    }

    override fun hideLoading() = with(viewBinding){
        pbLoading.makeGone()
    }

    override fun showErrorToast() {
        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() = presenter.onBackPressed()

}