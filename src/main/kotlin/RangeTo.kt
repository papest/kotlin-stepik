//operator fun MyDate.rangeTo(other: MyDate) = DateRange1(this, other)

data class DateRange1(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>

fun main() {
    println(MyDate(2024, 7, 8).rangeTo(MyDate(2024, 8, 1)))
}
