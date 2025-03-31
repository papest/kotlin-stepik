package mario

object Марио {
    val status = arrayOf("маленький", "большой", "огненный")
    var stIndex = 0
    var количествоЖизней = 3

    fun съестьГриб() {
        if (stIndex == 0) stIndex = 1
        println("Съел гриб.")
    }

    fun столкнутьсясГумбой() {
        if (stIndex > 0) stIndex--
        else количествоЖизней--
        println("Столкнулся с гумбой.")
    }

    fun съестьЗелёныйГриб() {
        println("Съел зелёный гриб.")
        количествоЖизней = количествоЖизней + 1
    }

    fun упастьвПропасть() {
        stIndex = 0
        количествоЖизней -= 1
        println("Упал в пропасть.")
    }

    fun съестьЦветок() {
        if (stIndex < 2) stIndex++
        else количествоЖизней++
        println("Съел цветок.")
    }


    override fun toString() = "Марио ${status[stIndex]}, количество жизней = $количествоЖизней."

}

fun gameOver() {
    println("Game over.")
}

fun main() {
    val actions = arrayOf(
        ::gameOver,
        Марио::съестьГриб,
        Марио::столкнутьсясГумбой,
        Марио::съестьЗелёныйГриб,
        Марио::упастьвПропасть,
        Марио::съестьЦветок
    )

    repeat(15) {
        println(Марио)
        if (Марио.количествоЖизней == 0) {
            gameOver()
            return
        }
        var номерДействия = readln().toInt()
        actions[номерДействия].invoke()
    }
    println(Марио)
    gameOver()

}
