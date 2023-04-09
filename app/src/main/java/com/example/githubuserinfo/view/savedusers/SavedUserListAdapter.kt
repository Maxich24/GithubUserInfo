package com.example.githubuserinfo.view.savedusers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubuserinfo.R
import com.example.githubuserinfo.databinding.ListItemUserBinding
import com.example.githubuserinfo.model.SavedUser

class SavedUserListAdapter(
    private val users: List<SavedUser>
) : RecyclerView.Adapter<SavedUserListAdapter.ViewHolder>() {

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

        fun bind(user: SavedUser) {
            Glide.with(binding.root)
                .load(user.avatarUrl)
                .placeholder(R.drawable.ghicon)
                .into(binding.userAvatar)
            binding.userName.text = user.name
            binding.userId.text = user.email
        }
    }
}