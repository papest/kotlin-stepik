import java.util.*

//object expression
fun getList(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    Collections.sort(arrayList, object : Comparator<Int> {
        override fun compare(o1: Int, o2: Int): Int {
            return o2 - o1
        }
    })
    return arrayList
}

// lambda
fun getListLambda(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    Collections.sort(arrayList) { o1, o2 -> o2 - o1 }
    return arrayList
}

// sortedDescending
fun getListWithSortedDescending(): List<Int> {
    return arrayListOf(1, 5, 2).sortedDescending()
}

fun main() {
    println(getListWithSortedDescending())
}
