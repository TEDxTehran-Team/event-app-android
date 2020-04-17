package co.eventbox.tedxtehran.network

import co.eventbox.tedxtehran.utilities.App
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.cache.normalized.CacheKey
import com.apollographql.apollo.cache.normalized.CacheKeyResolver
import com.apollographql.apollo.cache.normalized.sql.ApolloSqlHelper
import com.apollographql.apollo.cache.normalized.sql.SqlNormalizedCacheFactory
import okhttp3.OkHttpClient

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
object ApolloClientProvider {

    fun provide(okHttpClient: OkHttpClient): ApolloClient {

        // TODO :  Context Just for test
        val cacheFactory = SqlNormalizedCacheFactory(ApolloSqlHelper(App.context, "tedx_tehran_cache"))
        val resolver: CacheKeyResolver = object : CacheKeyResolver() {
            override fun fromFieldRecordSet(
                field: ResponseField,
                recordSet: MutableMap<String, Any>
            ): CacheKey {
                return formatCacheKey(recordSet["id"] as String?)
            }

            override fun fromFieldArguments(
                field: ResponseField,
                variables: Operation.Variables
            ): CacheKey {
                return formatCacheKey(field.resolveArgument("id", variables) as String?)

            }
        }


        return ApolloClient.builder().apply {
            serverUrl(APIs.END_POINT)
            normalizedCache(cacheFactory, resolver)
            okHttpClient(okHttpClient)
        }.build()
    }

    private fun formatCacheKey(id: String?) = when {
        id.isNullOrEmpty() -> CacheKey.NO_KEY
        else -> CacheKey.from(id)
    }
}