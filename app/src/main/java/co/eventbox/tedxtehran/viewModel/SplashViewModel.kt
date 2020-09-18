package co.eventbox.tedxtehran.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.eventbox.tedxtehran.respository.CacheDataRepository
import kotlinx.coroutines.launch

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
class SplashViewModel : BaseViewModel() {

    private val cacheRepository = CacheDataRepository()

    fun cacheData(): LiveData<Boolean> {
        this.cacheRepository.clearCache()
        val mutableLiveDataTest = MutableLiveData<Boolean>()
        launch {
            val either = cacheRepository.request()

            either.fold({
                mutableLiveDataTest.postValue(false)
            },{
                mutableLiveDataTest.postValue(it != null)
            })
        }

        return mutableLiveDataTest

    }
}