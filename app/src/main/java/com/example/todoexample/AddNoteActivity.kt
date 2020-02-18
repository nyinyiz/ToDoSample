package com.example.todoexample

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todoexample.data.local.AppDatabase
import com.example.todoexample.data.local.TodoEntity
import kotlinx.android.synthetic.main.activity_add_note.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class AddNoteActivity : AppCompatActivity() {

    public fun newInstance(context : Context) : Intent {
        return Intent(context, AddNoteActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        val db = AppDatabase(this)

        btnSave.setOnClickListener {
            if (!edTitle.text.isNullOrEmpty() && !edDescription.text.isNullOrEmpty()) {
                val sdf = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault())
                val currentDateandTime = sdf.format(Date())

                var todoEntity = TodoEntity(edTitle.text.toString(), edDescription.text.toString(),currentDateandTime)
                GlobalScope.launch {
                    db.TodoDao().insertAll(todoEntity)
                    finish()
                }

            }else {
                Toast.makeText(this, "Please fill title and description", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
