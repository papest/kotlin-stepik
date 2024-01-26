fun interface ClickListener {
    fun onClick(viewId: Int)
}

val clickListener = ClickListener { viewId ->
    println("Clicked on view with ID $viewId")
}

fun interface NumberPredicate {
    fun accept(n: Int): Boolean
}

val isEven = NumberPredicate { n -> n % 2 == 0 }

fun main() {
    
    clickListener.onClick(1)

    readln()
        .split(" ")
        .map { it.toInt() }
        .filter { isEven.accept(it) }
        .joinToString(" ")
        .also { println(it) }
}
