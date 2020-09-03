package co.eventbox.tedxtehran.respository

import android.util.Log
import co.eventbox.tedxtehran.network.Either
import co.eventbox.tedxtehran.network.XException
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.cache.http.HttpCachePolicy
import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery


/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
class CacheDataRepository :
    Repository<DashboardCacheQuery.Data, Operation.Variables, DashboardCacheQuery>() {

    suspend fun request(): Either<XException?, DashboardCacheQuery.Data?> {

        val operation = DashboardCacheQuery.builder().build()

        val response = fetch(operation, HttpCachePolicy.NETWORK_ONLY)

        response.fold({
            Log.d("TAG_AG", "Error : ${it?.errorMessage} | code : ${it?.httpCode}")

        }, {
            Log.d("TAG_AG", "data : ${it?.albums()?.first()?.cover()}")
        })

        return response
    }


}