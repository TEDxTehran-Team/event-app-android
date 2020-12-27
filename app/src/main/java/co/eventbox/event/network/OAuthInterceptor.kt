package co.eventbox.event.network

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */

class OAuthInterceptor(private val token: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Accept", "application/json")
            .addHeader("Content-Type", "application/json")
            .addHeader("Application-Token", token)
            .build()

        val response = chain.proceed(request)
        if (response.code() != 200) {
            OkHttpClientProvider.errorString = response.body()?.string()
        }
        return response
    }

}