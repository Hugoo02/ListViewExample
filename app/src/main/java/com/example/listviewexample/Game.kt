package com.example.listviewexample

import android.icu.text.CaseMap
import org.json.JSONObject


class Game {

    var title            : String? = null
    var gender           : String? = null
    var date             : String? = null

    constructor() {

    }

    constructor(title: String?, gender: String?, date: String?) {
        this.title            = title
        this.gender           = gender
        this.date             = date
    }

    fun toJson() : JSONObject {
        val jsonObject = JSONObject()

        jsonObject.put("title", title)
        jsonObject.put("gender", gender)
        jsonObject.put("date", date)

        return jsonObject
    }

    companion object {

        fun fromJson(jsonObject: JSONObject) : Game {
            val game = Game()

            game.title  = if (!jsonObject.isNull("title")) jsonObject.getString("title") else null
            game.gender = if (!jsonObject.isNull("gender")) jsonObject.getString("gender") else null
            game.date   = if (!jsonObject.isNull("date")) jsonObject.getString("date") else null

            return game
        }
    }

}
