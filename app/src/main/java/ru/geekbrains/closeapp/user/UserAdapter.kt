package ru.geekbrains.closeapp.user

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.closeapp.core.utils.loadImage
import ru.geekbrains.closeapp.databinding.ItemUserBinding
import ru.geekbrains.closeapp.model.GithubUser

typealias OnItemViewClick = (login: String) -> Unit

class UserAdapter(
    private var onItemViewClick: OnItemViewClick
) : RecyclerView.Adapter<UserAdapter.GithubUserViewHolder>() {

    var users: List<GithubUser> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        val binding = ItemUserBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return GithubUserViewHolder(binding, onItemViewClick)
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount() = users.size

    inner class GithubUserViewHolder(
        private val binding: ItemUserBinding,
        private val onItemViewClick: OnItemViewClick
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GithubUser) = with(binding) {
            tvUserLogin.text = item.login
            ivUserAvatar.loadImage(item.avatarUrl)
            root.setOnClickListener {
                onItemViewClick.invoke(item.login)
            }
        }
    }
}
