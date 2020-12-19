package co.eventbox.event.respository

import co.eventbox.event.network.Either
import co.eventbox.event.network.XException
import com.apollographql.apollo.co.eventbox.event.GetEventSponsorsQuery


/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
class SponsorsRepository :
    Repository<GetEventSponsorsQuery.Data, GetEventSponsorsQuery.Variables, GetEventSponsorsQuery>() {

    suspend fun request(eventID: Int) =
        GetEventSponsorsQuery.builder().eventID(eventID).build().run { fetch(this) }
}