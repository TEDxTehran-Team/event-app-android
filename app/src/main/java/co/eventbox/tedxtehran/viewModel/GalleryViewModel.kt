package co.eventbox.tedxtehran.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.eventbox.tedxtehran.respository.GalleryRepository
import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery
import kotlinx.coroutines.launch

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
class GalleryViewModel : BaseViewModel() {

    private val galleryRepository = GalleryRepository()

    fun albums(): LiveData<List<DashboardCacheQuery.AlbumByOrganizer>> {

        val albums = MutableLiveData<List<DashboardCacheQuery.AlbumByOrganizer>>()


        launch {
            galleryRepository.request().fold({
                albums.postValue(null)
            }, {
                albums.postValue(it?.albumByOrganizer())
            })


        }

        return albums
    }
}