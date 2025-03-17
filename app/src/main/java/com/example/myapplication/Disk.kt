package com.example.myapplication


class Disk(
    id: Int, accessibility: Boolean, name: String, val diskType: String
) : Subject(id, accessibility, name), HomeLendable {
    override fun getTypeName(): String = "Диск"
    override fun takeHomeAction() {
        accessibility = false
    }

    override fun printDetailedInfo(): String {
        return "$diskType $name доступен: ${if (accessibility) "Да" else "Нет"}"
    }
}