package com.example.month5_lesson6.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.month5_lesson6.formatFunct
import com.example.month5_lesson6.data.Task
import com.example.month5_lesson6.databinding.ItemBinding
import javax.inject.Inject

class Adapter @Inject constructor():RecyclerView.Adapter<Adapter.ViewHolder> (){
    inner class ViewHolder(private val binding: ItemBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(task: Task) {
            binding.itemTv.text = task.task
            itemView.setOnLongClickListener {
                delete(adapterPosition)
                return@setOnLongClickListener false
            }
            binding.timeView.text = task.time.formatFunct()


        } }
    private var array = ArrayList<Task>()

    fun delete(pos:Int): Task {
        return array[pos]
    }

    fun updateArray(task:List<Task>) {
        this.array = task as ArrayList<Task>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(array[position])    }

    override fun getItemCount(): Int {
        return  array.size }
}