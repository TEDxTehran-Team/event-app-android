package co.eventbox.event.respository

import co.eventbox.event.network.Either
import co.eventbox.event.network.XException
import com.apollographql.apollo.co.eventbox.event.GetTalkDetailQuery

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 9/14/20.
 */


class SpeakersDetailsRepository :
    Repository<GetTalkDetailQuery.Data, GetTalkDetailQuery.Variables, GetTalkDetailQuery>() {


    suspend fun request(id: Int): Either<XException?, GetTalkDetailQuery.Data?> {
        val operation = GetTalkDetailQuery.builder().id(id).build()

        return fetch(operation)
    }
}