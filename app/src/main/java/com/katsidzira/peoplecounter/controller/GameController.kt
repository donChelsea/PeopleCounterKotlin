package com.katsidzira.peoplecounter.controller

import com.katsidzira.peoplecounter.model.Counter

object GameController {

    private var counter: Counter = Counter()

    init {
        counter.people = 0
        counter.total = 0
    }

    fun getPeople(): Int? {
        return counter.people
    }

    fun getTotal(): Int? {
        return counter.total
    }
}