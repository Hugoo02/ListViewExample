package com.example.listviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class EditGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_game)

        //var editTextTitle = findViewById<EditText>(R.id.editTextTitle)
        //var editTextGender = findViewById<EditText>(R.id.editTextGender)
        //val buttonEdit = findViewById<Button>(R.id.buttonEdit)

        val bundle = intent.extras

        bundle?.let {
            editTextTitle.text = it.getString("title")
        }

    }
}