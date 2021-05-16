package com.example.listviewexample

import android.icu.text.CaseMap

class Game {

    var title : String? = null
    var gender : String? = null

    constructor(){

    }

    constructor(title: String?, gender: String?)
    {
        this.title = title
        this.gender = gender
    }

}