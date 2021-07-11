package com.example.listviewexample

import android.icu.text.CaseMap
import org.json.JSONObject


class Game {

    var title            : String? = null
    var gender           : String? = null

    constructor() {

    }

    constructor(title: String?, gender: String?) {
        this.title            = title
        this.gender           = gender
    }

    fun toJson() : JSONObject {
        val jsonObject = JSONObject()

        jsonObject.put("title", title)
        jsonObject.put("gender", gender)

        return jsonObject
    }

    companion object {

        fun fromJson(jsonObject: JSONObject) : Game {
            val game = Game()

            game.title  = if (!jsonObject.isNull("title")) jsonObject.getString("title") else null
            game.gender = if (!jsonObject.isNull("gender")) jsonObject.getString("gender") else null

            return game
        }
    }

}
