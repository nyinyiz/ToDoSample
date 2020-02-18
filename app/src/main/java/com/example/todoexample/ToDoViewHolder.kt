package com.example.todoexample

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.todoexample.data.local.TodoEntity
import kotlinx.android.synthetic.main.item_list_todo.view.*

class ToDoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    public fun binData(data : TodoEntity) {
        itemView.tvTitle.text = data.title
        itemView.tvDescription.text = data.content
        itemView.tvDate.text = data.dateTime
    }

}