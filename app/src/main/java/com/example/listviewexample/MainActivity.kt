package com.example.listviewexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Adapter
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import org.json.JSONObject
import kotlin.time.milliseconds

class MainActivity : AppCompatActivity() {

    var games : MutableList<Game> = arrayListOf()
    val gameAdapter = GameAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listViewGames = findViewById<ListView>(R.id.listViewGames)

        listViewGames.adapter = gameAdapter

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
                val intent = Intent(this, AddGameActivity::class.java)
                startActivityForResult(intent, 2000)

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

            val textViewName = view.findViewById<TextView>(R.id.textViewName)
            val textViewGender = view.findViewById<TextView>(R.id.textViewGender)
            val textViewDate = view.findViewById<TextView>(R.id.textViewDate)

            textViewName.text = games[position].title
            textViewGender.text = games[position].gender
            textViewDate.text = games[position].date

            view.setOnClickListener {

                val intent = Intent(this@MainActivity, EditGame::class.java)
                intent.putExtra("gameObject", games[position].toJson().toString())
                intent.putExtra("position", position)
                startActivityForResult(intent, 1000)

                notifyDataSetChanged()

            }

            return view

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1000) {
            if (resultCode == RESULT_OK){

                var position : Int? = null
                var gameStr: String? = null
                var game : Game? = null

                data?.extras.let{

                    position = it?.getInt("position")
                    gameStr = it?.getString("gameObject")

                }

                game = Game.fromJson(JSONObject(gameStr))

                games[position!!] = game
                gameAdapter.notifyDataSetChanged()

            }
        }

        else if (requestCode == 2000) {
            if (resultCode == RESULT_OK){

                var gameStr: String? = null
                var game : Game? = null

                data?.extras.let{

                    gameStr = it?.getString("gameObject")

                }

                game = Game.fromJson(JSONObject(gameStr))

                games.add(game)
                gameAdapter.notifyDataSetChanged()
            }
        }

    }

}


