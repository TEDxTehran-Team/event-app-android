package co.eventbox.tedxtehran.respository

import co.eventbox.tedxtehran.network.Either
import co.eventbox.tedxtehran.network.XException
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery
import com.apollographql.apollo.co.eventbox.tedxtehran.GetTalkDetailQuery

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