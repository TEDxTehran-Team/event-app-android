package co.eventbox.tedxtehran.network

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-10-29.
 */

sealed class Either<out A, out B> {
    data class Right<A, B>(val success: A) : Either<Nothing, A>()
    data class Left<A, B>(val failure: B) : Either<B, Nothing>()
}

