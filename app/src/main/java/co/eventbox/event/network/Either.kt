package co.eventbox.event.network

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-10-29.
 */


@Deprecated("Arrow pattern is Deprecated on Kotlin because koltin has provided Resualt<*>")
sealed class Either<out L, out R> {

    data class Left<out L>(val left: L) : Either<L, Nothing>()
    data class Right<out R>(val right: R) : Either<Nothing, R>()

    fun fold(leftFold: (L) -> Unit, rightFold: (R) -> Unit): Unit = when (this) {
        is Left -> leftFold(left)
        is Right -> rightFold(right)
    }


}


fun <L, R> Either<L, R>.toResult(): Result<R> {
    return when (this) {
        is Either.Right -> {
            Result.success(right)
        }
        is Either.Left -> {
            Result.failure(left as Throwable)
        }
    }
}