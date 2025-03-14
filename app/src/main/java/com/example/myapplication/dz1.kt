package com.example.myapplication

fun main() {
    val books = listOf(
        Book(1, true, "Маугли", 100, "Джозеф Киплинг"),
        Book(2, true, "Бесы>", 1000, "Федор Достоевский"),
        Book(3, true, "Три товарища", 450, "Эрих Мария Ремарк")
    )

    val newspapers = listOf(
        Newspaper(4, true, "Правда", 794),
        Newspaper(5, true, "Тайны вселенной", 123),
        Newspaper(6, true, "Новости", 456)
    )

    val disks = listOf(
        Disk(7, true, "Веном", "DVD"),
        Disk(8, true, "Форсаж", "CD"),
        Disk(9, true, "Марвел", "DVD")
    )

    while (true) {
        println(
            "1.Показать книги\n" + "2.Показать газеты\n" + "3.Показать диски\n"
        )
        when (readlnOrNull()?.toIntOrNull()) {
            1 -> {
                println("Cписок книг:")
                showItems(books)
            }
            2 -> {
                println("Cписок газет:")
                showItems(newspapers)
            }
            3 -> {
                println("Cписок дисков:")
                showItems(disks)
            }
            else -> println("Неправильный выбор. Пожалуйста, выберите снова.")
        }
    }
}

open class Subject(
    val id: Int,
    var accessibility: Boolean,
    val name: String
) {
    open fun printShortInfo(): String {
        return "$name доступна: ${if (accessibility) "Да" else "Нет"}"
    }
    open fun printDetailedInfo(): String{
        return ""
    }
}

class Book (
    id: Int,
    accessibility: Boolean,
    name: String,
    val pages: Int,
    val author: String
): Subject(id, accessibility, name) {
    override fun printDetailedInfo(): String {
        return "книга: $name (${pages} стр.) автора: $author с id: $id доступна: ${if (accessibility) "Да" else "Нет"}"
    }
}

class Newspaper (
    id: Int,
    accessibility: Boolean,
    name: String,
    val issueNumber: Int
): Subject(id, accessibility, name) {
    override fun printDetailedInfo(): String {
        return "выпуск: $issueNumber газеты $name с id: $id доступен: ${if (accessibility) "Да" else "Нет"}"
    }
}

class Disk (
    id: Int,
    accessibility: Boolean,
    name: String,
    val diskType: String
): Subject(id, accessibility, name) {
    override fun printDetailedInfo(): String {
        return "$diskType $name доступен: ${if (accessibility) "Да" else "Нет"}"
    }
}

fun showItems(items: List<Subject>) {
    items.forEachIndexed { index, item ->
        println("${index + 1}. ${item.printShortInfo()}")
    }

    println("Выберите объект:")
    val choice = readlnOrNull()?.toIntOrNull()
    if (choice != null && choice in 1..items.size) {
        val selectedItem = items[choice - 1]
        showActions(selectedItem)
    } else {
        println("Неправильный выбор. Пожалуйста, выберите снова.")
    }
}

fun showActions(item: Subject) {
    while (true) {
        println("Меню действий:")
        println(
            "1. Взять домой\n" + "2. Читать в читальном зале\n" + "3. Показать подробную информацию\n" + "4. Вернуть\n" + "5. Назад\n"
        )
        when (readlnOrNull()?.toIntOrNull()) {
            1 -> takeHome(item)
            2 -> readInHall(item)
            3 -> println(item.printDetailedInfo())
            4 -> returnItem(item)
            5 -> return
            else -> println("Неправильный выбор. Пожалуйста, выберите снова.")
        }
    }
}

fun takeHome(item: Subject) {
    if (item is Book || item is Disk) {
        if (item.accessibility) {
            item.accessibility = false
            println("Объект ${item::class.simpleName} с id ${item.id} взят домой.")
        } else {
            println("Объект недоступен для взятия домой.")
        }
    } else {
        println("Газеты нельзя взять домой.")
    }
}

fun readInHall(item: Subject) {
    if (item is Book || item is Newspaper) {
        if (item.accessibility) {
            item.accessibility = false
            println("Объект ${item::class.simpleName} с id ${item.id} взят в читальный зал.")
        } else {
            println("Объект недоступен для чтения в зале.")
        }
    } else {
        println("Диски нельзя читать в читальном зале.")
    }
}

fun returnItem(item: Subject) {
    if (!item.accessibility) {
        item.accessibility = true
        println("Объект ${item::class.simpleName} с id ${item.id} возвращен.")
    } else {
        println("Объект уже доступен.")
    }
}