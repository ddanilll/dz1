package com.example.myapplication

class Book (
    id: Int,
    accessibility: Boolean,
    name: String,
    val pages: Int,
    val author: String
): Subject(id, accessibility, name) {
    override val canTakeHome = true
    override val canReadInHall = true

    override fun getTypeName(): String = "Книга"
    override fun takeHomeAction() = "взята домой"
    override fun readInHallAction() = "читается в зале"

    override fun printDetailedInfo(): String {
        return "книга: $name (${pages} стр.) автора: $author с id: $id доступна: ${if (accessibility) "Да" else "Нет"}"
    }
}