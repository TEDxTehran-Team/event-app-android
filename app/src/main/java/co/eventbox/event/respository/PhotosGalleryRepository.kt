package co.eventbox.event.respository

import co.eventbox.event.network.Either
import co.eventbox.event.network.XException
import com.apollographql.apollo.co.eventbox.event.GetAlbumPhotosQuery

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
class PhotosGalleryRepository :
    Repository<GetAlbumPhotosQuery.Data, GetAlbumPhotosQuery.Variables, GetAlbumPhotosQuery>() {
    suspend fun request(id: Int) = GetAlbumPhotosQuery.builder().id(id).build().run {
        fetch(this)
    }

}