package co.eventbox.event.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.eventbox.event.respository.GalleryRepository
import co.eventbox.event.respository.PhotosGalleryRepository
import com.apollographql.apollo.co.eventbox.event.DashboardCacheQuery
import com.apollographql.apollo.co.eventbox.event.GetAlbumPhotosQuery
import kotlinx.coroutines.launch

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
class GalleryViewModel : BaseViewModel() {

    private val galleryRepository = GalleryRepository()
    private val photosGalleryRepository = PhotosGalleryRepository()

    fun albums(): LiveData<List<DashboardCacheQuery.Album>> {

        val albums = MutableLiveData<List<DashboardCacheQuery.Album>>()


        launch {
            galleryRepository.request().fold({
                albums.postValue(it?.albums())
            }, {
                albums.postValue(null)
            })


        }

        return albums
    }

    fun photos(id:Int): LiveData<List<GetAlbumPhotosQuery.Photo>> {

        val albums = MutableLiveData<List<GetAlbumPhotosQuery.Photo>>()


        launch {
            photosGalleryRepository.request(id).fold({
                albums.postValue(it?.album()?.photo())
            }, {
                albums.postValue(null)
            })


        }

        return albums
    }
}