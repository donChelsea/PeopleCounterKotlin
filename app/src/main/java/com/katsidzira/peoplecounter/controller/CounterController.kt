package com.katsidzira.peoplecounter.controller

import com.katsidzira.peoplecounter.model.Counter

object CounterController {

    private var counter: Counter = Counter(0, 0)

    fun getPeople(): Int? {
        return counter.people
    }

    fun getTotal(): Int? {
        return counter.total
    }

    fun addPerson() {
        counter.people += 1
        counter.total += 1
    }

    fun removePerson() {
        if (counter.people >= 1) counter.people -= 1
    }

    fun reset() {
        counter.people = 0
        counter.total = 0
    }

}