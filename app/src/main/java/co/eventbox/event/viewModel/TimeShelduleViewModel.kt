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