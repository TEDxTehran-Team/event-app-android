package co.eventbox.tedxtehran.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.eventbox.tedxtehran.respository.SponsorsRepository
import com.apollographql.apollo.co.eventbox.tedxtehran.GetEventSponsorsQuery
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
                values.postValue(null)
            }, {
                values.postValue(it?.sponsorsWithType())
            })
        }

        return values
    }

}