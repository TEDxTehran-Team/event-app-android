package co.eventbox.tedxtehran.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.eventbox.tedxtehran.respository.GalleryRepository
import co.eventbox.tedxtehran.respository.HomeRepository
import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery
import kotlinx.coroutines.launch

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 7/10/20.
 */
class HomeViewModel : BaseViewModel() {

    private val repository = HomeRepository()

    fun mainEvent(): LiveData<DashboardCacheQuery.MainEvent> {

        val data = MutableLiveData<DashboardCacheQuery.MainEvent>()


        launch {
            repository.fetch().fold({
                data.postValue(null)
            }, {
                data.postValue(it?.organizer()?.mainEvent())
            })

        }

        return data
    }
}