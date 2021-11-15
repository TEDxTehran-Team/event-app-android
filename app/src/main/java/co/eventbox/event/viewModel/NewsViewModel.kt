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

    private val newsMutableLiveData = MutableLiveData<List<DashboardCacheQuery.New>?>()
    val newsLiveData: LiveData<List<DashboardCacheQuery.New>?> = newsMutableLiveData

    init {
        news()
    }

    fun news() {

        launch {
            galleryRepository.request().fold({
                newsMutableLiveData.postValue(it?.news())
            }, {
                newsMutableLiveData.postValue(null)
            })
        }
    }
}