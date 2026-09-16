fun main() {

    val studentOne = Student(1, "Luc", "luc@gmail.com", true, listOf(17,null,null,16))
    val studentTwo = Student(2, "Manon", "manon@gmail.com", true, listOf(19,null,20,15))
    val studentThree = Student(3, "Corentin", null, false, listOf(null,null,null,null))

    studentOne.printGrades()
    studentTwo.printGrades()
    studentThree.printGrades()

    return
}

