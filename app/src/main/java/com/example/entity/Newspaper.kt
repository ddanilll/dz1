package com.example.entity

class Newspaper(
    id: Int, accessibility: Boolean, name: String, val issueNumber: Int
) : Subject(id, accessibility, name), InLibraryUse {

    override fun getTypeName(): String = "Газета"
    override fun readInHallAction() {
        accessibility = false
    }

    override fun printDetailedInfo(): String {
        return "выпуск: $issueNumber газеты $name с id: $id доступен: ${if (accessibility) "Да" else "Нет"}"
    }
}