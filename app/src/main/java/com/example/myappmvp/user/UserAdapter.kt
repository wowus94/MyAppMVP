package com.example.myappmvp.user

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myappmvp.databinding.ItemUserBinding
import com.example.myappmvp.model.GithubUser
import com.example.myappmvp.userlist.OnItemClickListener
import com.example.myappmvp.utils.loadImage

class UserAdapter(
    private val onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<UserAdapter.GithubUserViewHolder>() {

    var users: List<GithubUser> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GithubUserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount() = users.size


    inner class GithubUserViewHolder(
        private val binding: ItemUserBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GithubUser) = with(binding) {
            tvUserLogin.text = item.login
            ivUserAvatar.loadImage(item.avatarUrl)
            itemView.setOnClickListener {
                onItemClickListener.onItemClick(item.login)

            }
        }
    }
}