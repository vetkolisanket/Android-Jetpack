package com.sanket.androidjetpack.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sanket.androidjetpack.R
import com.sanket.androidjetpack.inflate
import com.sanket.androidjetpack.load
import com.sanket.androidjetpack.models.daos.Answer
import kotlinx.android.synthetic.main.item_main.view.*

/**
 * Created by Sanket on 07/08/20.
 */
class MainAdapter(private val answers: MutableList<Answer>): PagedListAdapter<Answer, MainAdapter.DataViewHolder>(
    DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object: DiffUtil.ItemCallback<Answer>() {
            override fun areItemsTheSame(oldItem: Answer, newItem: Answer): Boolean {
                return oldItem.answerId == newItem.answerId
            }

            override fun areContentsTheSame(oldItem: Answer, newItem: Answer): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(parent.inflate(R.layout.item_main))
    }

    override fun getItemCount(): Int = answers.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(answers[position])
    }

    fun addAnswers(answers: List<Answer>) {
        this.answers.apply {
            clear()
            addAll(answers)
        }
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(answer: Answer) {
            itemView.apply {
                tvUserName.text = answer.owner.displayName
                tvAnswerId.text = answer.answerId.toString()
                ivAvatar.load(answer.owner.profileImage)
            }
        }
    }

}