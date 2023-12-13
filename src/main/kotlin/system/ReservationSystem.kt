package system

import strings.Strings

class ReservationSystem {
    fun start() {
        var option: String
        println(Strings.greeting)

        while (true) {
            println(Strings.chooseOptions)
            option = readln()
            if (option == "4") return

            when (option) {
                "1" -> {}
                "2" -> {}
                "3" -> {}
                "5" -> {}
                "6" -> {}
                else -> println(Strings.wrongOption)
            }
        }
    }
}