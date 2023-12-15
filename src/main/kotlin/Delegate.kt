import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class D {
    var date: MyDate by EffectiveDate()
}

class EffectiveDate<R> : ReadWriteProperty<R, MyDate> {

    var timeInMillis: Long? = null

    override fun getValue(thisRef: R, property: KProperty<*>): MyDate {
        return timeInMillis!!.toMyDate()
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: MyDate) {
        timeInMillis = value.toMillis()
    }
}

fun Long.toMyDate() : MyDate =
    with(Instant.ofEpochMilli(this).atOffset(ZoneOffset.UTC)) { MyDate(year, month.ordinal, dayOfMonth) }

fun MyDate.toMillis() : Long =
    LocalDateTime.of(year, month, dayOfMonth,0,0,0).toInstant(ZoneOffset.UTC).toEpochMilli()

fun main() {
    val d = D()
    d.date = MyDate(2024, 3, 5)
    println(d.date)
}