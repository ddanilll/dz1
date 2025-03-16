package com.example.myapplication

open class Subject(
    val id: Int,
    var accessibility: Boolean,
    val name: String
): TakeHomePolicy, ReadInHallPolicy {
    override val canTakeHome: Boolean = false
    override val canReadInHall: Boolean = false

    open fun getTypeName(): String = "Неизвестный тип"
    override fun takeHomeAction() = "взят домой"
    override fun readInHallAction() = "взят в читальный зал"

    open fun printShortInfo(): String {
        return "$name доступна: ${if (accessibility) "Да" else "Нет"}"
    }
    open fun printDetailedInfo(): String{
        return ""
    }
}