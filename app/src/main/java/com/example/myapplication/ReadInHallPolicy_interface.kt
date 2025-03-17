package com.example.myapplication

interface ReadInHallPolicy {
    val canReadInHall: Boolean
    fun readInHallAction(): String
}