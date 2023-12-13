package data

class Customer(customerName: String) {
    private val customerName: String
    private var customerPoint: Int
    private val customerPointHistory: ArrayList<Pair<String, Int>>

    init {
        this.customerName = customerName
        customerPoint = 200_000 // 임의의 값
        customerPointHistory = arrayListOf()

        customerPointHistory.add(Pair("입금", this.customerPoint))
    }

    fun getCustomerName() = this.customerName
    fun getCustomerPointHistory() = this.customerPointHistory

    fun spendMoney(money: Int) {
        this.customerPoint -= money
        customerPointHistory.add(Pair("출금", money))
    }
}