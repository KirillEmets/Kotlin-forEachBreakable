import kotlin.Exception

private class ContinueException : Exception()
private class BreakException : Exception()

class ForEachScope {
    val Break: Nothing
        get() =
            throw BreakException()

    val Continue: Nothing
        get() =
            throw ContinueException()

}

fun <T> Iterable<T>.forEachBreakable(block: ForEachScope.(T) -> Unit) {
    val scope = ForEachScope()
    try {
        forEach {
            try {
                block(scope, it)
            } catch (e: ContinueException) {
                // Interrupts single item and continues
            }
        }
    }
    catch (e: BreakException) {
        // Breaks the entire loop
    }
}