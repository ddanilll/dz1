package com.example.entity

abstract class Subject(
    val id: Int, var accessibility: Boolean, val name: String
) {
    open fun getTypeName(): String = "Неизвестный тип"

    open fun printShortInfo(): String {
        return "$name доступна: ${if (accessibility) "Да" else "Нет"}"
    }

    open fun printDetailedInfo(): String {
        return ""
    }
}