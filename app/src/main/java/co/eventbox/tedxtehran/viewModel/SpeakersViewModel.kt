package co.eventbox.tedxtehran.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.eventbox.tedxtehran.network.Either
import co.eventbox.tedxtehran.network.XException
import co.eventbox.tedxtehran.respository.SpeakersRepository
import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery
import kotlinx.coroutines.launch

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 7/24/20.
 */
class SpeakersViewModel : BaseViewModel() {

    private val speakersRepository = SpeakersRepository()

    fun speackers(): LiveData<Either<XException?, DashboardCacheQuery.Data?>> {
        val liveData = MutableLiveData<Either<XException?, DashboardCacheQuery.Data?>>()

        launch {
            val either = speakersRepository.fetch()
            liveData.postValue(either)
        }
        return liveData

    }
}