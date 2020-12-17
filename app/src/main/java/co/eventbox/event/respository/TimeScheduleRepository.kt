package co.eventbox.event.respository

import co.eventbox.event.network.Either
import co.eventbox.event.network.XException
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.co.eventbox.event.DashboardCacheQuery

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 9/14/20.
 */

class TimeScheduleRepository :
    Repository<DashboardCacheQuery.Data, Operation.Variables, DashboardCacheQuery>() {


    suspend fun request(): Either<XException?, DashboardCacheQuery.Data?> {
        val operation = DashboardCacheQuery.builder().build()

        return fetch(operation)
    }
}