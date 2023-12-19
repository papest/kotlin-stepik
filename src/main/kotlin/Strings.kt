import java.util.stream.Collectors

class TransformToInt {
    val startValue = 0

    fun transform(acc: Int, curr: Char) = acc or 1.shl(curr - 'a')

    fun extractResult(value: Int) = value
}

class CountA {
    val startValue = IntArray(2) { 0 }

    fun transform(acc: IntArray, curr: Char) = acc.apply {
        if (curr == 'a') this[0]++ else this[0] = 0
        this[1] = this.maxOf { it }
    }

    fun extractResult(value: IntArray): Int = value[1]
}

fun deduplicateSeqs(s: String): String =
    StringBuilder().apply {
        s.forEach { if (!endsWith(it)) append(it) }
    }.toString()

const val HEX_RADIX = 16

fun toHex(s: String): String = s.chars().mapToObj { it.toString(HEX_RADIX) }.collect(Collectors.joining(""))

fun fromHex(s: String): String = s.windowed(2, 2).map { it.toInt(HEX_RADIX).toChar() }.joinToString("")

fun main() {
    println(with(TransformToInt()) { "aaaabcd".fold(startValue, ::transform) })
    with(CountA()) { "abbbaa".fold(startValue, ::transform).also { println(extractResult(it)) } }
    println(deduplicateSeqs("ssssKKllhhhkK"))
    println(toHex("aabb"))
    println(fromHex("61616262"))
}



