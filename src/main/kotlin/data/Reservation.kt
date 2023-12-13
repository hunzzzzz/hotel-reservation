package data

import java.time.LocalDate

class Reservation(customer: Customer, room: Room, checkInDate: LocalDate, checkOutDate: LocalDate) {
    private val customer: Customer
    private val room: Room
    private val checkInDate: LocalDate
    private val checkOutDate: LocalDate

    fun getCustomer() = this.customer
    fun getRoom() = this.room
    fun getCheckInDate() = this.checkInDate
    fun getCheckOutDate() = this.checkOutDate

    init {
        this.customer = customer
        this.room = room
        this.checkInDate = checkInDate
        this.checkOutDate = checkOutDate

        this.customer.spendMoney(room.getRoomPrice())
    }

    override fun toString() =
        "사용자: ${customer.getCustomerName()}, 방번호: ${room.getRoomNumber()}, 체크인: ${checkInDate}, 체크아웃: ${checkOutDate}"
}