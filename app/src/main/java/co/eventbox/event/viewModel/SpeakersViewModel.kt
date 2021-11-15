package co.eventbox.event.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.eventbox.event.respository.SpeakersDetailsRepository
import co.eventbox.event.respository.SpeakersRepository
import com.apollographql.apollo.co.eventbox.event.DashboardCacheQuery
import com.apollographql.apollo.co.eventbox.event.GetTalkDetailQuery
import kotlinx.coroutines.launch

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 7/24/20.
 */
class SpeakersViewModel : BaseViewModel() {

    private val speakersRepository = SpeakersRepository()
    private var speakersDetailsRepository = SpeakersDetailsRepository()

    private var _speakers = MutableLiveData<Result<DashboardCacheQuery.Data?>>()
    var speakers: LiveData<Result<DashboardCacheQuery.Data?>> = _speakers

    init {
        speakers()
    }

    fun speakers() {
        launch {
            val either = speakersRepository.fetch()
            _speakers.postValue(either)
        }
    }

    fun talkDetails(id: Int): LiveData<Result<GetTalkDetailQuery.Data?>> {
        val liveData = MutableLiveData<Result<GetTalkDetailQuery.Data?>>()

        launch {
            val either = speakersDetailsRepository.request(id)
            liveData.postValue(either)
        }
        return liveData
    }
}