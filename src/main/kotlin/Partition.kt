import java.util.*

fun <T> Collection<T>.partitionTo(
    collection1: MutableCollection<T>,
    collection2: MutableCollection<T>,
    predicate: (T) -> Boolean
): Pair<MutableCollection<T>, MutableCollection<T>> {
    val pair = partition(predicate)
    for (t: T in pair.first) {
        collection1.add(t)
    }
    for (t: T in pair.second) {
        collection2.add(t)
    }
    return Pair(collection1, collection2)
}

fun partitionWordsAndLines() {
    val (words, lines) =
        listOf("a", "a b", "c", "d e").partitionTo(ArrayList<String>(), ArrayList<String>()) { s: String ->
            !s.contains(
                " "
            )
        }
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) =
        setOf('a', '%', 'r', '}').partitionTo(HashSet<Char>(), HashSet<Char>()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
}
