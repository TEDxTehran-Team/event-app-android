package co.eventbox.tedxtehran.viewModel

import co.eventbox.tedxtehran.respository.CacheDataRepository
import kotlinx.coroutines.launch

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
class SplashViewModel : BaseViewModel() {

    private val cacheRepository = CacheDataRepository()

    fun test(){
        launch {
            cacheRepository.request()
        }

    }
}