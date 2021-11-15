package co.eventbox.event.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.eventbox.event.respository.TimeScheduleRepository
import com.apollographql.apollo.co.eventbox.event.DashboardCacheQuery
import kotlinx.coroutines.launch

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
class TimeScheduleViewModel : BaseViewModel() {

    private val repository = TimeScheduleRepository()

    private val daysMutableLiveData = MutableLiveData<List<DashboardCacheQuery.Day>?>()
    val daysLiveData: LiveData<List<DashboardCacheQuery.Day>?> = daysMutableLiveData

    init {
        days()
    }

    fun days() {

        launch {
            repository.request().fold({
                daysMutableLiveData.postValue(it?.organizer()?.mainEvent()?.days())
            }, {
                daysMutableLiveData.postValue(null)
            })
        }

    }
}