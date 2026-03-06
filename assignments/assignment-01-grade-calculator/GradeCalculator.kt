data class Student(
    val name: String,
    val score1: Double?,
    val score2: Double?,
    val score3: Double?
) {
    fun average(): Double {
        val s1 = score1 ?: 0.0
        val s2 = score2 ?: 0.0
        val s3 = score3 ?: 0.0
        return (s1 + s2 + s3) / 3
    }

    fun grade(): String {
        return when {
            average() >= 90 -> "A"
            average() >= 80 -> "B"
            average() >= 70 -> "C"
            average() >= 60 -> "D"
            else -> "F"
        }
    }

    fun status(): String = if (average() >= 60) "Pass" else "Fail"
}

fun main() {
    print("Enter student name: ")
    val name = readLine()

    print("Enter score 1: ")
    val s1 = readLine()?.toDoubleOrNull()

    print("Enter score 2: ")
    val s2 = readLine()?.toDoubleOrNull()

    print("Enter score 3: ")
    val s3 = readLine()?.toDoubleOrNull()

    val student = Student(
        name = name ?: "Unknown",
        score1 = s1,
        score2 = s2,
        score3 = s3
    )

    println("\nStudent : ${student.name}")
    println("Average : ${"%.2f".format(student.average())}")
    println("Grade   : ${student.grade()}")
    println("Status  : ${student.status()}")
}
