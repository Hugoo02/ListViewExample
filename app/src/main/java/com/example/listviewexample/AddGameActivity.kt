package com.example.listviewexample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.listviewexample.Utils.UtilFunctions
import org.json.JSONObject
import java.time.LocalDateTime

class AddGameActivity : AppCompatActivity() {

    lateinit var game : Game

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_game)

        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextGender = findViewById<EditText>(R.id.editTextGender)

        buttonAdd.setOnClickListener {

            game = Game(editTextName.text.toString(), editTextGender.text.toString(), UtilFunctions().currentDate())
            Toast.makeText(this, "Jogo adicionado com sucesso!", Toast.LENGTH_SHORT).show()

            val intent = Intent()
            intent.putExtra("gameObject", game.toJson().toString())
            setResult(Activity.RESULT_OK, intent)
            finish()

        }
    }
}