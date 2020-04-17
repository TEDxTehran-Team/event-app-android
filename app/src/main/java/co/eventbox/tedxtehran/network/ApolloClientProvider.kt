package co.eventbox.tedxtehran.network

import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
object ApolloClientProvider {

    fun provide(okHttpClient: OkHttpClient): ApolloClient {
        return ApolloClient.builder().apply {
            serverUrl(APIs.END_POINT)
            okHttpClient(okHttpClient)
        }.build()
    }
}