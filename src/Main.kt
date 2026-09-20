import kotlin.math.*

fun main() {
    val studentOne = Student(1, "Luc", "luc@gmail.com", true, listOf(45,55,null,60))
    val studentTwo = Student(2, "Manon", "manon@gmail.com", true, listOf(92,null,70,86))
    val studentThree = Student(3, "Corentin", null, false, listOf(42,68,88,74))
    val students = listOf(studentOne, studentTwo, studentThree)

    val activeStudents = students.filter { it.active }
    printStudentNames(activeStudents, "Active students: ")

    val sortedStudents = students.sortedBy { it.name }
    printStudentNames(sortedStudents, "\nStudents sorted by name: ")

    val successfulStudents = students.filter { (it.getAverageGrade() ?: 0.0) >= 60.0}
    printStudentNames(successfulStudents, "\nSuccessful students (average >= 60): ")

    val bestStudent = students.maxByOrNull { student -> student.getAverageGrade() ?: Double.MIN_VALUE}
    println("\nBest student: ${bestStudent?.name ?: "unavailable"}\n")

    val firstTask = Task(0, "FirstTask", false)
    val secondTask = Task(1, "SecondTask", false)

    val tasks: MutableList<Task> = mutableListOf<Task>()

    tasks.addTask(firstTask)
    tasks.addTask(secondTask)

    tasks.printUncompletedTasks()
    tasks.markTaskAsComplete(firstTask)

    tasks.printUncompletedTasks()

    tasks.removeTask(secondTask)
    tasks.printUncompletedTasks()

    var newGrades = applyOperationOnIntList(students[0].getValidGrades()) { min(100, it + 5) }
    println("\nNew grades: $newGrades")
    newGrades = applyOperationOnIntList(students[0].getValidGrades()) { it * 2 }
    println("\nNew grades: $newGrades")
    newGrades = applyOperationOnIntList(students[0].getValidGrades()) { (it * 0.2).toInt() }
    println("\nNew grades: $newGrades")

    return
}

fun printStudentNames(students: List<Student>, title: String) {
    println(title)
    students.forEach { println("   - ${it.name}") }
}

fun applyOperationOnIntList(list: List<Int>, operation: (Int) -> Int): List<Int> {
    return list.map { operation(it) }
}