data class Student(
    val id: Int,
    val name: String,
    val email: String?,
    val active: Boolean,
    val grades: List<Int?>){
}

fun Student.getEmailLength(): Int{
    return email?.length ?: 0
}

fun Student.getValidGrades(): List<Int>{
    return grades.filterNotNull()
}

fun Student.getBestGrade(): Int?{
    return getValidGrades().maxOrNull()
}

fun Student.getAverageGrade(): Double?{
    val validGrades = getValidGrades()
    return if (validGrades.isEmpty()) null else validGrades.average()
}

fun Student.getNullGradesAmount(): Int{
    return grades.size - getValidGrades().size
}

fun Student.printProfile() {

    val emailString = email ?: "Unknown email"
    val activeString = if (active) "Active" else "Inactive"

    println("Name: $name, Email: $emailString, Status: $activeString")
}

fun Student.printEmailLength() {
    println("$name email length: ${getEmailLength()}")
}

fun Student.printGrades() {
    println("$name grades summary:")
    println("   Valid grades: ${getValidGrades().ifEmpty { "None" }}")
    println("   Best grade: ${getBestGrade()?: "Best grade unavailable"}")
    println("   Average grade: ${getAverageGrade() ?: "Average unavailable"}")
    println("   Amount of absent grades: ${getNullGradesAmount()}")
}
