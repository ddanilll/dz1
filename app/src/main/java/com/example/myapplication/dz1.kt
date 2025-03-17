package com.example.myapplication

fun main() {
    val librarySubject = listOf(
        Book(1, true, "Маугли", 100, "Джозеф Киплинг"),
        Book(2, true, "Бесы", 1000, "Федор Достоевский"),
        Book(3, true, "Три товарища", 450, "Эрих Мария Ремарк"),
        Newspaper(4, true, "Правда", 794),
        Newspaper(5, true, "Тайны вселенной", 123),
        Newspaper(6, true, "Новости", 456),
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
                showItems(librarySubject.filterIsInstance<Book>())
            }

            2 -> {
                println("Cписок газет:")
                showItems(librarySubject.filterIsInstance<Newspaper>())
            }

            3 -> {
                println("Cписок дисков:")
                showItems(librarySubject.filterIsInstance<Disk>())
            }

            else -> println("Неправильный выбор. Пожалуйста, выберите снова.")
        }
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
    when {
        !item.accessibility -> println("Объект недоступен")
        item is HomeLendable -> {
            item.takeHomeAction()
            println("${item.getTypeName()} с id ${item.id} взят домой")
        }

        else -> println("Нельзя взять домой")
    }
}

fun readInHall(item: Subject) {
    when {
        !item.accessibility -> println("Объект недоступен")
        item is InLibraryUse -> {
            item.readInHallAction()
            println("${item.getTypeName()} с id ${item.id} взят в читальный зал")
        }

        else -> println("Нельзя читать в зале")
    }
}

fun returnItem(item: Subject) {
    if (!item.accessibility) {
        item.accessibility = true
        println("Объект ${item.getTypeName()} с id ${item.id} возвращен.")
    } else {
        println("Объект уже доступен.")
    }
}