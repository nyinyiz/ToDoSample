package com.example.todoexample

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoexample.data.local.TodoEntity

class ToDoRecyclerAdapter(var context: Context, var callBack : ToDoViewHolder.ItemViewCallBack) : RecyclerView.Adapter<ToDoViewHolder>() {
    private var todoList: List<TodoEntity> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        return ToDoViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_list_todo,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.binData(todoList[position], callBack)
    }

    fun setToDo(datas: List<TodoEntity>) {
        todoList = datas
    }
}