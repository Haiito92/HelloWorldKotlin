class StudentAccount(
    val owner: Student,
    initialBalance: Double,
) {
    var balance = initialBalance
        private set

    fun deposit(amount: Double): Boolean {
        if (amount <= 0) return false

        balance += amount

        return true
    }

    fun withdraw(amount: Double): Boolean {
        if (amount <= 0 || amount > balance) return false

        balance -= amount

        return true
    }
}