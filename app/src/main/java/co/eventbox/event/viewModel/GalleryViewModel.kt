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

    private var _albumsMutableLiveData = MutableLiveData<List<DashboardCacheQuery.Album>?>()
    var albumsLiveData: LiveData<List<DashboardCacheQuery.Album>?> = _albumsMutableLiveData

    private var _photosMutableLiveData = MutableLiveData<List<GetAlbumPhotosQuery.Photo>?>()
    var photosLiveData: LiveData<List<GetAlbumPhotosQuery.Photo>?> = _photosMutableLiveData

    init {
        albums()
    }

    fun albums() {
        launch {
            galleryRepository.request().fold({
                _albumsMutableLiveData.postValue(it?.albums())
            }, {
                _albumsMutableLiveData.postValue(null)
            })
        }
    }

    fun photos(id: Int) {
        launch {
            photosGalleryRepository.request(id).fold({
                _photosMutableLiveData.postValue(it?.album()?.photo())
            }, {
                _photosMutableLiveData.postValue(null)
            })


        }
    }
}