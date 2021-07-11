package com.example.listviewexample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.listviewexample.databinding.ActivityAddGameBinding.inflate
import org.json.JSONObject

class EditGame : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_game)

        var game : Game? = null
        var position: Int? = null

        var editTextTitle = findViewById<EditText>(R.id.editTextTitle)
        var editTextGender = findViewById<EditText>(R.id.editTextGender)
        val buttonEdit = findViewById<Button>(R.id.buttonEdit)

        val bundle = intent.extras

        bundle?.let {
            game = Game.fromJson(JSONObject(it.getString("gameObject")))
            position = it.getInt("position")
        }

        editTextTitle.setText(game!!.title)
        editTextGender.setText(game!!.gender)

        buttonEdit.setOnClickListener {

            game!!.title = editTextTitle.text.toString()
            game!!.gender =  editTextGender.text.toString()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("gameObject", Game(editTextTitle.text.toString(), editTextGender.text.toString()).toJson().toString())
            intent.putExtra("position", position)
            setResult(Activity.RESULT_OK, intent)
            finish()

        }


    }
}