import kotlin.math.truncate

fun mean(a: Int, b: Int): Int = truncate((a.toDouble() + b.toDouble()) / 2.0).toInt()

fun mean(a: Long, b: Long): Long = truncate((a.toDouble() + b.toDouble()) / 2.0).toLong()

fun main() {
    println(mean(0L, 0L))
}