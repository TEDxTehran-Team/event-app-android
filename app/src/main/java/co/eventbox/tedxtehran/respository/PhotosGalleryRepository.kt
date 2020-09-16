package co.eventbox.tedxtehran.respository

import co.eventbox.tedxtehran.network.Either
import co.eventbox.tedxtehran.network.XException
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery
import com.apollographql.apollo.co.eventbox.tedxtehran.GetAlbumPhotosQuery


/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
class PhotosGalleryRepository :
    Repository<GetAlbumPhotosQuery.Data, GetAlbumPhotosQuery.Variables, GetAlbumPhotosQuery>() {

    suspend fun request(id:Int): Either<XException?, GetAlbumPhotosQuery.Data?> {
        val operation = GetAlbumPhotosQuery.builder().id(id).build()

        return fetch(operation)
    }
}