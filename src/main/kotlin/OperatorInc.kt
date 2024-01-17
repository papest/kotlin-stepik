data class C(val v: Int) {
    operator fun inc(d: Int = 2) = C(v + d * 10)
}

fun main() {
    var v = C(10)
    println(v++)
    println(v)
}
