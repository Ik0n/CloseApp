package ru.geekbrains.closeapp.repo

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.closeapp.databinding.ItemRepoBinding
import ru.geekbrains.closeapp.model.Repo

typealias OnItemViewClick = (login: String,name: String) -> Unit

class RepoAdapter(
    private var onItemViewClick: OnItemViewClick
) : RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    var repos: List<Repo> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    lateinit var login: String

    inner class RepoViewHolder(
        private val binding: ItemRepoBinding,
        private val onItemViewClick: OnItemViewClick
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(repo: Repo) = with(binding) {
            tvName.text = repo.name
            tvFullName.text = repo.fullName
            tvDescription.text = repo.description
            root.setOnClickListener {
                onItemViewClick.invoke(login, repo.name)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val binding = ItemRepoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RepoViewHolder(binding, onItemViewClick)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    override fun getItemCount() = repos.size
}