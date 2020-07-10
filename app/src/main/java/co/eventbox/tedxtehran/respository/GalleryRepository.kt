package co.eventbox.tedxtehran.respository

import co.eventbox.tedxtehran.network.Either
import co.eventbox.tedxtehran.network.XException
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.cache.http.HttpCachePolicy
import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery


/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
class GalleryRepository :
    Repository<DashboardCacheQuery.Data, Operation.Variables, DashboardCacheQuery>() {

    suspend fun request(): Either<XException?, DashboardCacheQuery.Data?> {
        return fetch(DashboardCacheQuery.builder().build(), HttpCachePolicy.CACHE_FIRST)
    }


}