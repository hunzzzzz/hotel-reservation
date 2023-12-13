package data

class Customer(customerName: String) {
    private val customerName: String

    init {
        this.customerName = customerName
    }
    fun getCustomerName() = customerName
}