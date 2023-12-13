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

            when (option) {
                "1" -> {
                    customerName = getCustomerName()
                    roomNumber = getRoomNumber()
                    checkInDate = getCheckInDate(roomNumber)
                    checkOutDate = getCheckOutDate(checkInDate)
                    completeReservation(customerName, roomNumber, checkInDate, checkOutDate)
                }
                "2" -> showReservationList(reservationList)
                "3" -> showReservationListSorted(reservationList)
                "4" -> {
                    println(Strings.QUIT_SYSTEM)
                    break
                }
                "5" -> printFinancialReport(reservationList)
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
    private fun getCheckInDate(roomNum: Int): LocalDate {
        var date: LocalDate
        while (true) {
            println(Strings.GET_CHECKIN_DATE)
            date = LocalDate.parse(readln(), DateTimeFormatter.ofPattern("yyyyMMdd"))

            if (LocalDate.now() > date)
                System.err.println(Strings.WRONG_CHECKIN_DATE)
            else if (!isRoomAvailable(roomNum, date)) {
                System.err.println(Strings.ROOM_UNAVAILABLE)
            } else return date
        }
    }

    // 방 예약 가능 여부
    private fun isRoomAvailable(roomNum: Int, date: LocalDate): Boolean {
        for (reservation in reservationList) {
            if ((roomNum == reservation.getRoom()
                    .getRoomNumber()) && (date >= reservation.getCheckInDate()) && (date <= reservation.getCheckOutDate())
            ) return false
        }
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

    // 예약 완료 (객체 저장)
    private fun completeReservation(name: String, roomNum: Int, checkin: LocalDate, checkout: LocalDate) {
        println(Strings.COMPLETE_RESERVATION)
        reservationList.add(
            Reservation(Customer(name), Room(roomNum), checkin, checkout)
        )
    }

    // 예약 목록 출력
    private fun showReservationList(list: ArrayList<Reservation>) {
        println(Strings.RESERVATION_LIST)
        for (i in list.indices)
            println("${i + 1}. ${list[i]}")
    }

    // 예약 목록 출력 (정렬)
    private fun showReservationListSorted(list: ArrayList<Reservation>) {
        println(Strings.RESERVATION_LIST_SORTED)

        val copiedList = arrayListOf<Reservation>()
        copiedList.addAll(list)
        copiedList.sortBy { it.getCheckInDate() }
        showReservationList(copiedList)
    }

    private fun printFinancialReport(list: ArrayList<Reservation>) {
        println(Strings.GET_NAME_IN_FINANCIAL_REPORT)
        val name = readln()
        var customer: Customer? = null

        for (reservation in list) {
            if (reservation.getCustomer().getCustomerName() == name)
                customer = reservation.getCustomer()
        }
        if (customer == null)
            System.err.println(Strings.WRONG_NAME)
        else {
            for (pair in customer.getCustomerPointHistory()) {
                if (pair.first == "입금")
                    println("포인트 ${pair.second}점 입금되었습니다.")
                else
                    println("예약금으로 ${pair.second}점 출금되었습니다.")
            }
        }
    }
}