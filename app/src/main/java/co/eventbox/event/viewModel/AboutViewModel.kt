package co.eventbox.event.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.eventbox.event.respository.AboutRepository
import com.apollographql.apollo.co.eventbox.event.GetAboutsQuery
import kotlinx.coroutines.launch

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
class AboutViewModel : BaseViewModel() {

    private val repository = AboutRepository()

    fun abouts(): LiveData<List<GetAboutsQuery.About>> {

        val values = MutableLiveData<List<GetAboutsQuery.About>>()


        launch {
            repository.request().fold({
                values.postValue(it?.organizer()?.abouts())
            }, {
                values.postValue(null)
            })


        }

        return values
    }

}