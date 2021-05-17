package com.example.listviewexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Adapter
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

var games : MutableList<Game> = arrayListOf(Game("Minecraft", "Criatividade"))

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val adapterGames : GameAdapter()
        val listViewGames = findViewById<ListView>(R.id.listViewGames)

        listViewGames.adapter = GameAdapter()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_games, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)

        when (item.itemId){
            R.id.itemAdd -> {
                startActivity(Intent(this, AddGameActivity::class.java))
                return true
            }
        }

        return false
    }

    inner class  GameAdapter : BaseAdapter(){

        override fun getCount(): Int {
            return games.size
        }

        override fun getItem(position: Int): Any {
            return games[position]
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            var view = layoutInflater.inflate(R.layout.row_game, parent, false)

            var textViewName = view.findViewById<TextView>(R.id.textViewName)
            var textViewGender = view.findViewById<TextView>(R.id.textViewGender)

            textViewName.text = games[position].title
            textViewGender.text = games[position].gender

            view.setOnClickListener {

                val intent = Intent(this@MainActivity, EditGame::class.java)

                intent.putExtra("title", games[position].title)
                intent.putExtra("gender", games[position].gender)
                intent.putExtra("position", position)

                startActivity(intent)

                notifyDataSetChanged()

            }



            return view

        }

    }

}

