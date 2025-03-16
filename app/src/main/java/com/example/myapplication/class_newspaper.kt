package com.example.myapplication

class Newspaper (
    id: Int,
    accessibility: Boolean,
    name: String,
    val issueNumber: Int
): Subject(id, accessibility, name) {
    override val canReadInHall = true

    override fun getTypeName(): String = "Газета"
    override fun readInHallAction() = "читается в зале"

    override fun printDetailedInfo(): String {
        return "выпуск: $issueNumber газеты $name с id: $id доступен: ${if (accessibility) "Да" else "Нет"}"
    }
}