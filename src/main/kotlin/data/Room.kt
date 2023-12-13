package data

class Room(roomNumber: Int) {
    private val roomNumber: Int

    init {
        this.roomNumber = roomNumber
    }

    fun getRoomNumber() = roomNumber
}