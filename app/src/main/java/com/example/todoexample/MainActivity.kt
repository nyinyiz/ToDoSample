package com.example.todoexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoexample.data.local.AppDatabase
import com.example.todoexample.data.local.TodoEntity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var dataList : List<TodoEntity>
    private lateinit var db : AppDatabase
    lateinit var adapter : ToDoRecyclerAdapter

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = AppDatabase(this)

        adapter = ToDoRecyclerAdapter(this@MainActivity)
        rvTodo.layoutManager = LinearLayoutManager(this@MainActivity)
        rvTodo.adapter = adapter


    }

    override fun onResume() {
        super.onResume()

        GlobalScope.launch {
            dataList = db.TodoDao().getAll()
            adapter.setToDo(dataList)

        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_add -> {
                Toast.makeText(this,"Add TODO list",Toast.LENGTH_LONG).show()
                startActivity(AddNoteActivity().newInstance(this))
            }
        }
        return super.onOptionsItemSelected(item)

    }

}
