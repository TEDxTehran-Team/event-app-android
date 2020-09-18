package co.eventbox.tedxtehran.respository

import co.eventbox.tedxtehran.network.Either
import co.eventbox.tedxtehran.network.XException
import com.apollographql.apollo.api.cache.http.HttpCachePolicy
import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery


/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
class CacheDataRepository :
    Repository<DashboardCacheQuery.Data, DashboardCacheQuery.Variables, DashboardCacheQuery>() {

    suspend fun request(): Either<XException?, DashboardCacheQuery.Data?> {
        val operation = DashboardCacheQuery.builder().organizer(1).build()
        return fetch(operation, HttpCachePolicy.NETWORK_ONLY)
    }


}