package data

class Room(roomNumber: Int) {
    private val roomNumber: Int
    private val roomPrice: Int

    init {
        this.roomNumber = roomNumber
        this.roomPrice = 100_000 // 임의의 값
    }

    fun getRoomNumber() = this.roomNumber
    fun getRoomPrice() = this.roomPrice
}