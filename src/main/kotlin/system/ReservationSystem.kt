package system

import data.Customer
import data.Reservation
import data.Room
import resources.Strings
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ReservationSystem {
    private val reservationList: ArrayList<Reservation> = ArrayList()
    fun start() {
        var option: String
        var customerName: String
        var roomNumber: Int
        var checkInDate: LocalDate
        var checkOutDate: LocalDate

        println(Strings.GREETING)

        while (true) {
            println(Strings.CHOOSE_OPTIONS)
            option = readln()
            if (option == "4") return

            when (option) {
                "1" -> {
                    customerName = getCustomerName()
                    roomNumber = getRoomNumber()
                    checkInDate = getCheckInDate()
                    checkOutDate = getCheckOutDate(checkInDate)
                    completeReservation(customerName, roomNumber, checkInDate, checkOutDate)
                }

                "2" -> {}
                "3" -> {}
                "5" -> {}
                "6" -> {}
                else -> System.err.println(Strings.WRONG_OPTION)
            }
        }
    }

    // 이름 입력
    private fun getCustomerName(): String {
        println(Strings.GET_NAME)
        return readln()
    }

    // 방 번호 입력
    private fun getRoomNumber(): Int {
        var num: Int?
        while (true) {
            println(Strings.GET_ROOM_NUMBER)
            num = readln().toIntOrNull()

            if (num != null) {
                if ((num >= 100) && (num <= 999)) {
                    return num
                } else System.err.println(Strings.WRONG_ROOM_NUMBER)
            } else System.err.println(Strings.WRONG_OPTION)
        }
    }

    // 체크인 날짜 입력
    private fun getCheckInDate(): LocalDate {
        var date: LocalDate
        while (true) {
            println(Strings.GET_CHECKIN_DATE)
            date = LocalDate.parse(readln(), DateTimeFormatter.ofPattern("yyyyMMdd"))

            if (LocalDate.now() > date)
                System.err.println(Strings.WRONG_CHECKIN_DATE)
            else if (!isRoomAvailable(date)) {
                System.err.println(Strings.ROOM_UNAVAILABLE)
            } else return date
        }
    }

    private fun isRoomAvailable(inputDate: LocalDate): Boolean {
        return true
    }

    // 체크아웃 날짜 입력
    private fun getCheckOutDate(checkInDate: LocalDate): LocalDate {
        var date: LocalDate
        while (true) {
            println(Strings.GET_CHECKOUT_DATE)
            date = LocalDate.parse(readln(), DateTimeFormatter.ofPattern("yyyyMMdd"))

            if (checkInDate < date)
                return date
            else System.err.println(Strings.WRONG_CHECKOUT_DATE)
        }
    }

    private fun completeReservation(name: String, roomNum: Int, checkin: LocalDate, checkout: LocalDate) {
        println(Strings.COMPLETE_RESERVATION)
        reservationList.add(
            Reservation(Customer(name), Room(roomNum), checkin, checkout)
        )
    }
}