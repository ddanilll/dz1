package com.example.myapplication

interface TakeHomePolicy {
    val canTakeHome: Boolean
    fun takeHomeAction(): String
}