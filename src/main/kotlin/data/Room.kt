package data

import resources.Prices

class Room(roomNumber: Int) {
    private val roomNumber: Int
    private val roomPrice: Int

    init {
        this.roomNumber = roomNumber
        this.roomPrice = Prices.ROOM_DEFAULT_AMOUNT // 임의의 값
    }

    fun getRoomNumber() = this.roomNumber
    fun getRoomPrice() = this.roomPrice
}