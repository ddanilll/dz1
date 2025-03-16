package com.example.myapplication


class Disk (
    id: Int,
    accessibility: Boolean,
    name: String,
    val diskType: String
): Subject(id, accessibility, name) {
    override val canTakeHome = true

    override fun getTypeName(): String = "Диск"
    override fun takeHomeAction() = "взят домой"

    override fun printDetailedInfo(): String {
        return "$diskType $name доступен: ${if (accessibility) "Да" else "Нет"}"
    }
}