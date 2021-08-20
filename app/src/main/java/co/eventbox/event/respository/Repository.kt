package co.eventbox.event.respository

import co.eventbox.event.Config
import co.eventbox.event.network.*
import com.apollographql.apollo.api.Mutation
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.cache.http.HttpCachePolicy
import com.apollographql.apollo.coroutines.toDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
abstract class Repository<D : Operation.Data, V : Operation.Variables, O : Operation<D, D, V>> :
    CoroutineScope,
    ResultFetcher<O, D> {


    private val token1 = "56fe1591-c5c1-4113-aba3-73fca1f5aacd" // English Data Token
    private val token = "7b9c5f16-0882-4334-a828-e67ce8ccf201" // Farsi Data Token
    private val okHttpProvider = OkHttpClientProvider.provide(Config.token)
    private val apolloClientProvider = ApolloClientProvider.provide(okHttpProvider)

    fun clearCache() {
        this.apolloClientProvider.clearNormalizedCache()
    }


    override suspend fun fetch(
        operation: O,
        httpCachePolicy: HttpCachePolicy.Policy,
        delaySecond: Int
    ): Result<D?> {
        delay(delaySecond.toLong())
        return fetch(operation, httpCachePolicy).toResult()
    }


    @Deprecated("Use fetch():Result<D?> instead of this.")
    private suspend fun fetch(
        operation: O,
        httpCachePolicy: HttpCachePolicy.Policy = HttpCachePolicy.CACHE_FIRST,
    ): Either<XException?, D?> {

        val either: Either<XException?, D?>

        if (httpCachePolicy == HttpCachePolicy.NETWORK_ONLY) {
            apolloClientProvider.clearNormalizedCache()
        }

        val deferred = if (operation is Query<*, *, *>) {
            apolloClientProvider.query(operation as Query<D, D, V>)
                .httpCachePolicy(httpCachePolicy)
                .toDeferred()
        } else {
            apolloClientProvider.mutate(operation as Mutation<D, D, V>)
                .toDeferred()
        }

        either = try {
            val response = deferred.await()

            if (response.hasErrors()) {
                val error = response.errors?.first()?.message()
                Either.Left(XException(response.hashCode(), error))
            } else {
                Either.Right(response.data())
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Either.Left(XException(e.hashCode(), e.localizedMessage))
        }

        return either

    }


    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

}


interface ResultFetcher<O, D> {

    /**
     * fetching from server by Apollo and return a Result<T>
     *
     * @param operation  Operation of Apollo
     * @param httpCachePolicy a flag of Http Policy
     * @param delaySecond a time for delaying request.
     * @return Result<D?>
     */
    suspend fun fetch(
        operation: O,
        httpCachePolicy: HttpCachePolicy.Policy = HttpCachePolicy.CACHE_FIRST,
        delaySecond: Int = 0
    ): Result<D?>


}