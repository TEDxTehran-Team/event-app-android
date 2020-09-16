package co.eventbox.tedxtehran.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.eventbox.tedxtehran.respository.GalleryRepository
import co.eventbox.tedxtehran.respository.PhotosGalleryRepository
import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery
import com.apollographql.apollo.co.eventbox.tedxtehran.GetAlbumPhotosQuery
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
                albums.postValue(null)
            }, {
                albums.postValue(it?.albums())
            })


        }

        return albums
    }

    fun photos(id:Int): LiveData<List<GetAlbumPhotosQuery.Photo>> {

        val albums = MutableLiveData<List<GetAlbumPhotosQuery.Photo>>()


        launch {
            photosGalleryRepository.request(id).fold({
                albums.postValue(null)
            }, {
                albums.postValue(it?.album()?.photo())
            })


        }

        return albums
    }
}