class Invokable {
    var numberOfInvocations: Int = 0
        private set

    operator fun invoke(): Invokable {
        numberOfInvocations++
        return this
    }
}

fun invokeTwice(invokable: Invokable) = invokable()()

fun invokeThrice(invokable: Invokable) = invokable()()()

fun main() {
    println(invokeThrice(Invokable()).numberOfInvocations)
}

