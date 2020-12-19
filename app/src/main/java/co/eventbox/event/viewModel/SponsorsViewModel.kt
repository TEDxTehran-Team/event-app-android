package co.eventbox.event.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.eventbox.event.respository.SponsorsRepository
import com.apollographql.apollo.co.eventbox.event.GetEventSponsorsQuery
import kotlinx.coroutines.launch

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
class SponsorsViewModel : BaseViewModel() {

    private val repository = SponsorsRepository()

    fun sponsors(eventID:Int): LiveData<List<GetEventSponsorsQuery.SponsorsWithType>> {

        val values = MutableLiveData<List<GetEventSponsorsQuery.SponsorsWithType>>()

        launch {
            repository.request(eventID).fold({
                values.postValue(it?.sponsorsWithType())
            }, {
                values.postValue(null)
            })
        }

        return values
    }

}