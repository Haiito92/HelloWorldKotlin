fun main() {


    val studentOne = Student(1, "Luc", "luc@gmail.com", true, listOf(45,55,null,60))
    val studentTwo = Student(2, "Manon", "manon@gmail.com", true, listOf(92,null,70,86))
    val studentThree = Student(3, "Corentin", null, false, listOf(42,68,88,74))
    val students = listOf(studentOne, studentTwo, studentThree)

    val activeStudents = students.filter { it.active }

    println("Active students: ")
    activeStudents.forEach { println("   - ${it.name}") }

    val sortedStudents = students.sortedBy { it.name }
    //val studentsName= students.map { it.name }
    //val sortedNames = studentsName.sorted()
    println("\nStudents sorted by name: ")
    sortedStudents.forEach { println("   - ${it.name}") }
    //sortedNames.forEach { println("   - $it") }

    val successfulStudents = students.filter { (it.getAverageGrade() ?: 0.0) >= 60.0}
    println("\nSuccessful students (average >= 60): ")
    successfulStudents.forEach { println("   - ${it.name}") }

    val bestStudent = students.maxByOrNull { student -> student.getAverageGrade() ?: Double.MIN_VALUE}
    println("\nBest student: ${bestStudent?.name ?: "unavailable"}")
    return
}

