package co.eventbox.tedxtehran.network

import okhttp3.OkHttpClient

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
class OkHttpClientProvider private constructor() {

    companion object {

        var errorString: String? = null
        private var okHttpClient: OkHttpClient? = null

        fun provide(token: String): OkHttpClient {
            if (okHttpClient == null) {
                okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(OAuthInterceptor(token))
                    .build()
            }

            return okHttpClient!!
        }

        fun reCreate(token: String) {
            okHttpClient = null
            provide(token)
        }

    }

}