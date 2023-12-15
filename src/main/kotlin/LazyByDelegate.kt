class LazyProperty1(val initializer: () -> Int) {
    val lazyValue: Int by lazy(initializer)
}