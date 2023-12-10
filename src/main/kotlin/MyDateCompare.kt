data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return if (year == other.year) if (month == other.month) dayOfMonth - other.dayOfMonth
        else month - other.month
        else year - other.year
    }
}

fun compare(date1: MyDate, date2: MyDate) = date1 < date2
