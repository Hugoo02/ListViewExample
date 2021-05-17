package com.example.listviewexample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.listviewexample.databinding.ActivityAddGameBinding.inflate

class EditGame : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_game)

        var editTextTitle = findViewById<EditText>(R.id.editTextTitle)
        var editTextGender = findViewById<EditText>(R.id.editTextGender)
        val buttonEdit = findViewById<Button>(R.id.buttonEdit)
        var position = 0

        val bundle = intent.extras

        bundle?.let {
            editTextTitle.hint = it.getString("title")
            editTextGender.hint = it.getString("gender")
            position = it.getInt("position")
        }

        buttonEdit.setOnClickListener {

            games[position].title = editTextTitle.text.toString()
            games[position].gender =  editTextGender.text.toString()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }


    }
}