import java.time.LocalDate

class DateRange2(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
    override operator fun iterator(): Iterator<MyDate> {
        return IteratorMyDate()
    }

    fun nextDay(date: MyDate): MyDate {
        return with(date) {
            val next = LocalDate.of(year, month, dayOfMonth).plusDays(1)
            MyDate(next.year, next.month.ordinal + 1, next.dayOfMonth)
        }
    }

    inner class IteratorMyDate : Iterator<MyDate> {
        var startIteration = true
        var next = start
        override fun next(): MyDate {
            if (startIteration) {
                startIteration = false
            } else if (next == end) {
                throw NoSuchElementException()
            } else next = nextDay(next)
            return next
        }

        override fun hasNext(): Boolean {
            return next < end
        }
    }
}


fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in DateRange2(firstDate, secondDate)) {
        handler(date)
    }
}

fun main() {
    iterateOverDateRange(MyDate(2022, 1, 2), MyDate(2022, 1, 10), ::println)
}
