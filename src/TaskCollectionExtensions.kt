fun MutableList<Task>.addTask(newTask: Task) {
    if(this.any{it.id == newTask.id}){
        println("Can't add task '${newTask.title}' with id: ${newTask.id}. Already have a task with this id.")
        return
    }
    this.add(newTask)
}

fun MutableList<Task>.removeTask(task: Task) {
    this.removeIf { it == task }
}

fun MutableList<Task>.markTaskAsComplete(inTask: Task) {
    val index = this.indexOfFirst { it == inTask }

    if(index != -1){
        this[index] = this[index].copy(completed = true)
    }
}

fun MutableList<Task>.printUncompletedTasks(){
    println("\nUncompleted tasks:")
    this.filter{!it.completed}.forEach{println("   - ${it.title}")}
}