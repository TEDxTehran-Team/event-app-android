package co.eventbox.event.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.eventbox.event.respository.HomeRepository
import com.apollographql.apollo.co.eventbox.event.DashboardCacheQuery
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
                data.postValue(it?.organizer()?.mainEvent())
            }, {
                data.postValue(null)
            })

        }

        return data
    }
}