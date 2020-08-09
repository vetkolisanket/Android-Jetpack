package com.sanket.androidjetpack.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanket.androidjetpack.R
import com.sanket.androidjetpack.inflate
import com.sanket.androidjetpack.load
import com.sanket.androidjetpack.models.daos.Answer
import kotlinx.android.synthetic.main.item_main.view.*

/**
 * Created by Sanket on 07/08/20.
 */
class MainAdapter(private val answers: MutableList<Answer>): RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(answer: Answer) {
            itemView.apply {
                tvUserName.text = answer.owner.displayName
                tvAnswerId.text = answer.answerId.toString()
                ivAvatar.load(answer.owner.profileImage)
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

}