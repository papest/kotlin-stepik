package mario

object Марио {

    var большойЛи = false

    init {
        println(
            "Началось.\nIt’s-a me, Mario!"
        )
    }

    fun съестьГриб() {
        большойЛи = true
        println("Марио съел гриб.")
    }

    fun столкнутьсяГумба() {
        большойЛи = false
        System.out.println("Марио столкнулся с гумбой.")
    }

    fun isBig() {
        println("Марио большой - ${Марио.большойЛи}.")
    }
}

fun gameOver() {
    println("Game over.")
}

fun game() {
    val actions =
        arrayOf(Марио::isBig, Марио::съестьГриб, Марио::isBig, Марио::столкнутьсяГумба, Марио::isBig, ::gameOver)
    actions.forEach { it.invoke() }
}

fun main() {
    game()
}

