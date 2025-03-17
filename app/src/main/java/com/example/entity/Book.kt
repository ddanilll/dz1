package com.example.entity

class Book(
    id: Int, accessibility: Boolean, name: String, val pages: Int, val author: String
) : Subject(id, accessibility, name), HomeLendable, InLibraryUse {
    override fun getTypeName(): String = "Книга"
    override fun takeHomeAction() {
        accessibility = false
    }

    override fun readInHallAction() {
        accessibility = false
    }

    override fun printDetailedInfo(): String {
        return "книга: $name (${pages} стр.) автора: $author с id: $id доступна: ${if (accessibility) "Да" else "Нет"}"
    }
}