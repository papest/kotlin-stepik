data class Person(private val name: String, private val age: Int)

fun getPeople(): List<Person> {
    return listOf(Person("Alice", 29), Person("Bob", 31))
}

fun main() {
    println(getPeople())
}
