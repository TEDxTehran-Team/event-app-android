package co.eventbox.tedxtehran.respository

import co.eventbox.tedxtehran.network.ApolloClientProvider
import co.eventbox.tedxtehran.network.Either
import co.eventbox.tedxtehran.network.OkHttpClientProvider
import co.eventbox.tedxtehran.network.XException
import com.apollographql.apollo.api.Mutation
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.cache.http.HttpCachePolicy
import com.apollographql.apollo.coroutines.toDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
abstract class Repository<D : Operation.Data, V : Operation.Variables, O : Operation<D, D, V>> :
    CoroutineScope {


    suspend fun fetch(operation: O,httpCachePolicy: HttpCachePolicy.Policy = HttpCachePolicy.CACHE_FIRST): Either<XException?, D?> {

        val either: Either<XException?, D?>

        //fetch user token or app token identifier
        val token = ""
        val okHttpProvider = OkHttpClientProvider.provide(token)
        val apolloClientProvider = ApolloClientProvider.provide(okHttpProvider)

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