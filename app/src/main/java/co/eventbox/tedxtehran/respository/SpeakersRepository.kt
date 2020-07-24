package co.eventbox.tedxtehran.respository

import co.eventbox.tedxtehran.network.Either
import co.eventbox.tedxtehran.network.XException
import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 7/24/20.
 */
class SpeakersRepository :
    Repository<DashboardCacheQuery.Data, DashboardCacheQuery.Variables, DashboardCacheQuery>() {


    suspend fun fetch(): Either<XException?, DashboardCacheQuery.Data?> {

        val operation = DashboardCacheQuery.builder().organizer(1).build()

        return fetch(operation)

    }
}