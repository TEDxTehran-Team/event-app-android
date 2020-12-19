package co.eventbox.event.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.eventbox.event.respository.GalleryRepository
import com.apollographql.apollo.co.eventbox.event.DashboardCacheQuery
import kotlinx.coroutines.launch

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 7/10/20.
 */
class NewsViewModel : BaseViewModel() {

    private val galleryRepository = GalleryRepository()

    fun news(): LiveData<List<DashboardCacheQuery.New>> {

        val albums = MutableLiveData<List<DashboardCacheQuery.New>>()


        launch {
            galleryRepository.request().fold({
                albums.postValue(it?.news())
            }, {
                albums.postValue(null)
            })


        }

        return albums
    }
}