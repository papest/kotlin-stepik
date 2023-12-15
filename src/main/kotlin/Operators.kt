import java.util.*
import TimeInterval.*


enum class TimeInterval { DAY, WEEK, YEAR }

data class Interval(val timeInterval: TimeInterval, val number: Int)

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = addTimeIntervals(timeInterval, 1)

operator fun MyDate.plus(interval: Interval): MyDate = addTimeIntervals(interval.timeInterval, interval.number)

operator fun Interval.plus(date: MyDate): MyDate = date.addTimeIntervals(timeInterval, number)

operator fun TimeInterval.times(number: Int): Interval = Interval(this, number)

operator fun Int.times(timeInterval: TimeInterval): Interval = Interval(timeInterval, this)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}

fun MyDate.addTimeIntervals(timeInterval: TimeInterval, number: Int): MyDate {
    val c = Calendar.getInstance()
    c.set(year, month, dayOfMonth)
    when (timeInterval) {
        DAY -> c.add(Calendar.DAY_OF_MONTH, number)
        WEEK -> c.add(Calendar.WEEK_OF_MONTH, number)
        YEAR -> c.add(Calendar.YEAR, number)
    }
    return MyDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE))
}
