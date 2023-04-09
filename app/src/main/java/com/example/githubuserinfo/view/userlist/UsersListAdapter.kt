package com.example.githubuserinfo.view.userlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubuserinfo.R
import com.example.githubuserinfo.databinding.ListItemUserBinding
import com.example.githubuserinfo.model.GithubUser

class UsersListAdapter(
    private val users: List<GithubUser>,
    private val onItemClickListener: (GithubUser) -> Unit
) : RecyclerView.Adapter<UsersListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemUserBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size

    inner class ViewHolder(private val binding: ListItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClickListener(users[adapterPosition])
            }
        }

        fun bind(user: GithubUser) {
            Glide.with(binding.root)
                .load(user.avatarUrl)
                .placeholder(R.drawable.ghicon)
                .into(binding.userAvatar)
            binding.userName.text = user.login
            binding.userId.text = user.id.toString()
        }
    }
}