package co.eventbox.tedxtehran.respository

import co.eventbox.tedxtehran.model.Talks
import retrofit2.http.GET

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-10-30.
 */
interface ApiService {

    @GET("events/talks/all/")
    suspend fun getTalks(): List<Talks>
}