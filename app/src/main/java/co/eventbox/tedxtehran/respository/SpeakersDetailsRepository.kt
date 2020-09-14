package co.eventbox.tedxtehran.respository

import co.eventbox.tedxtehran.network.Either
import co.eventbox.tedxtehran.network.XException
import com.apollographql.apollo.co.eventbox.tedxtehran.GetTalkDetailQuery

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