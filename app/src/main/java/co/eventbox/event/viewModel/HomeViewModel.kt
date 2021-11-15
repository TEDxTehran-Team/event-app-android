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

    private val mainEventMutableLiveData = MutableLiveData<DashboardCacheQuery.MainEvent?>()
    val mainEventLiveData: LiveData<DashboardCacheQuery.MainEvent?> = mainEventMutableLiveData


    init {
        mainEvent()
    }

    fun mainEvent() {
        launch {
            repository.fetch().fold({
                mainEventMutableLiveData.postValue(it?.organizer()?.mainEvent())
            }, {
                mainEventMutableLiveData.postValue(null)
            })

        }
    }
}