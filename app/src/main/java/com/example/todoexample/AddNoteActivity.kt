package com.example.todoexample

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AddNoteActivity : AppCompatActivity() {

    public fun newInstance(context : Context) : Intent {
        return Intent(context, AddNoteActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)



    }
}
