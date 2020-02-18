package com.example.todoexample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.todoexample.data.local.AppDatabase
import com.example.todoexample.data.local.TodoEntity
import kotlinx.android.synthetic.main.activity_add_note.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class AddNoteActivity : AppCompatActivity() {

    private var mId : Int = 0
    private lateinit var db: AppDatabase
    lateinit var data : TodoEntity


    fun newInstance(context: Context, id : Int): Intent {
        var intent = Intent(context, AddNoteActivity::class.java)
        intent.putExtra("ID",id)
        return intent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        db = AppDatabase(this)

        mId = intent.getIntExtra("ID", 0)

        Toast.makeText(this,"Your ToDo id : $mId",Toast.LENGTH_SHORT).show()

        btnSave.setOnClickListener {

            if (!edTitle.text.isNullOrEmpty() && !edDescription.text.isNullOrEmpty()) {
                val format = SimpleDateFormat("M/d/y H:m:ss")
                val currentDate = format.format(Date()).toString()

                var todoEntity =
                    TodoEntity(edTitle.text.toString(), edDescription.text.toString(), currentDate)

                GlobalScope.launch {
                    if (mId != 0) {
                        db.TodoDao().updateTodo(todoEntity)
                    }else {
                        db.TodoDao().insertAll(todoEntity)
                    }
                    finish()
                }

            } else {
                Toast.makeText(this, "Please fill title and description", Toast.LENGTH_SHORT).show()
            }
        }



    }

    private fun showDetail() {

        edTitle.setText(data.title)
        edDescription.setText(data.content)
        btnSave.text = "Edit"
    }
}
