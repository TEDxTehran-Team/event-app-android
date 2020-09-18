package co.eventbox.tedxtehran.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.eventbox.tedxtehran.respository.GalleryRepository
import co.eventbox.tedxtehran.respository.PhotosGalleryRepository
import co.eventbox.tedxtehran.respository.TimeScheduleRepository
import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery
import com.apollographql.apollo.co.eventbox.tedxtehran.GetAlbumPhotosQuery
import kotlinx.coroutines.launch

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
class TimeShelduleViewModel : BaseViewModel() {

    private val repository = TimeScheduleRepository()

    fun days(): LiveData<List<DashboardCacheQuery.Day>> {

        val values = MutableLiveData<List<DashboardCacheQuery.Day>>()

        launch {
            repository.request().fold({
                values.postValue(null)
            }, {
                values.postValue(it?.organizer()?.mainEvent()?.days())
            })


        }

        return values
    }
}