package com.example.todoexample

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.todoexample.data.local.TodoEntity
import kotlinx.android.synthetic.main.item_list_todo.view.*

class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun binData(data: TodoEntity, clickListener : ItemViewCallBack) {
        itemView.tvTitle.text = data.id.toString()
        itemView.tvDescription.text = data.content
        itemView.tvDate.text = data.dateTime

        itemView.setOnClickListener {
            clickListener.onTapToDoItem(data)
        }
    }

    interface ItemViewCallBack {
        fun onTapToDoItem(data : TodoEntity)
    }
}