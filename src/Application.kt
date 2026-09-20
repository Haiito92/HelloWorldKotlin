import java.awt.Taskbar

class Application (
    val students: List<Student>,
    val tasks: MutableList<Task> = mutableListOf<Task>()
){

    fun run() {
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

        addTask(firstTask)
        addTask(secondTask)

        printUncompletedTask()
        markTaskAsComplete(firstTask)

        printUncompletedTask()

        removeTask(secondTask)
        printUncompletedTask()

    }

    fun printStudentNames(students: List<Student>, title: String) {
        println(title)
        students.forEach { println("   - ${it.name}") }
    }

    fun addTask(newTask: Task) {
        if(tasks.any{it.id == newTask.id}){
            println("Can't add task '${newTask.title}' with id: ${newTask.id}. Already have a task with this id.")
            return
        }
        tasks.add (newTask)
    }

    fun removeTask(task: Task) {
        tasks.removeIf { it == task }
    }

    fun markTaskAsComplete(inTask: Task) {
        val index = tasks.indexOfFirst { it == inTask }

        if(index != -1){
            tasks[index] = tasks[index].copy(completed = true)
        }
    }

    fun printUncompletedTask(){
        println("\nUncompleted tasks:")
        tasks.filter{!it.completed}.forEach{println("   - ${it.title}")}
    }
}