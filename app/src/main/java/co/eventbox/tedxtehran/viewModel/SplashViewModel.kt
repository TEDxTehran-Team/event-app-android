package co.eventbox.tedxtehran.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.eventbox.tedxtehran.respository.CacheDataRepository
//import co.eventbox.tedxtehran.respository.CacheDataRepository
import kotlinx.coroutines.launch

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
class SplashViewModel : BaseViewModel() {

    private val cacheRepository = CacheDataRepository()

    fun test(): LiveData<Boolean> {
        this.cacheRepository.clearCache()
        Log.d("TAG_AG","test start")
        val mutableLiveDataTest = MutableLiveData<Boolean>()
        launch {
            val either = cacheRepository.request()

            either.fold({
                Log.d("TAG_AG","faild")
                mutableLiveDataTest.postValue(false)
            },{
                mutableLiveDataTest.postValue(it != null)
                Log.d("TAG_AG","success : ${it != null}" )
            })
        }

        return mutableLiveDataTest

    }
}