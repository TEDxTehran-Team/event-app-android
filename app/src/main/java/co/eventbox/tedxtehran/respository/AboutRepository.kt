package co.eventbox.tedxtehran.respository

import co.eventbox.tedxtehran.network.Either
import co.eventbox.tedxtehran.network.XException
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery
import com.apollographql.apollo.co.eventbox.tedxtehran.GetAboutsQuery


/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
class AboutRepository :
    Repository<GetAboutsQuery.Data, Operation.Variables, GetAboutsQuery>() {

    suspend fun request(): Either<XException?, GetAboutsQuery.Data?> {
        val operation = GetAboutsQuery.builder().build()

        return fetch(operation)
    }
}