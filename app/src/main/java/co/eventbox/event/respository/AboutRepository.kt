package co.eventbox.event.respository

import co.eventbox.event.network.Either
import co.eventbox.event.network.XException
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.co.eventbox.event.GetAboutsQuery


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