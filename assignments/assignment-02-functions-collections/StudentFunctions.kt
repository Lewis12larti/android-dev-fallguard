data class Student(val name: String, val score: Double) {

    fun isValidScore(): Boolean = score in 0.0..100.0

    fun gradeLetter(): String {
        return when {
            score >= 90 -> "A"
            score >= 80 -> "B"
            score >= 70 -> "C"
            score >= 60 -> "D"
            else -> "F"
        }
    }
}

fun processStudents(students: List<Student>, operation: (Student) -> Unit) {
    students.forEach { operation(it) }
}

fun main() {
    val students = listOf(
        Student("Alice", 95.0),
        Student("Bob", 72.0),
        Student("Charlie", 58.0),
        Student("David", 84.0)
    )

    // filter — students who passed
    val passed = students.filter { it.score >= 60 }
    println("Students who passed:")
    passed.forEach { println("${it.name} - Grade: ${it.gradeLetter()}") }

    println()

    // lambda passed to higher-order function
    println("All students:")
    processStudents(students) { student ->
        println("${student.name} : ${student.score} -> ${student.gradeLetter()}")
    }

    println()

    // map — names of top students
    val topStudents = students
        .filter { it.gradeLetter() == "A" }
        .map { it.name }
    println("Grade A students: $topStudents")
}
