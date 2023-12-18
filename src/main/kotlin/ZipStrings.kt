fun zipPairs(s: String): List<String> = s.windowed(2, 2)

fun main() {
    println(zipPairs("012345678"))
    println(zipPairs(""))
}