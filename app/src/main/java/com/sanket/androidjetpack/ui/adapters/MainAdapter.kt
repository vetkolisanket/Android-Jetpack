package com.sanket.androidjetpack.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanket.androidjetpack.R
import com.sanket.androidjetpack.inflate
import com.sanket.androidjetpack.load
import com.sanket.androidjetpack.models.User
import kotlinx.android.synthetic.main.item_main.view.*

/**
 * Created by Sanket on 07/08/20.
 */
class MainAdapter(private val users: MutableList<User>): RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            itemView.apply {
                textViewUserName.text = user.name
                textViewUserEmail.text = user.email
                imageViewAvatar.load(user.avatar)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(parent.inflate(R.layout.item_main))
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun addUsers(users: List<User>) {
        this.users.apply {
            clear()
            addAll(users)
        }
    }

}