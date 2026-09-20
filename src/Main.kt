fun main() {
    val studentOne = Student(1, "Luc", "luc@gmail.com", true, listOf(45,55,null,60))
    val studentTwo = Student(2, "Manon", "manon@gmail.com", true, listOf(92,null,70,86))
    val studentThree = Student(3, "Corentin", null, false, listOf(42,68,88,74))
    val app = Application(listOf(studentOne, studentTwo, studentThree))
    app.run()

    return
}
