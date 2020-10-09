package co.eventbox.tedxtehran.respository

import co.eventbox.tedxtehran.network.Either
import co.eventbox.tedxtehran.network.XException
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery
import com.apollographql.apollo.co.eventbox.tedxtehran.GetAboutsQuery
import com.apollographql.apollo.co.eventbox.tedxtehran.GetEventSponsorsQuery


/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
class SponsorsRepository :
    Repository<GetEventSponsorsQuery.Data, GetEventSponsorsQuery.Variables, GetEventSponsorsQuery>() {

    suspend fun request(): Either<XException?, GetEventSponsorsQuery.Data?> {
        return fetch(GetEventSponsorsQuery.builder().eventID(1).build())
    }
}