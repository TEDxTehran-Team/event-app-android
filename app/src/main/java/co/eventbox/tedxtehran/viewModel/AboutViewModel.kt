package co.eventbox.tedxtehran.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.eventbox.tedxtehran.respository.AboutRepository
import co.eventbox.tedxtehran.respository.GalleryRepository
import co.eventbox.tedxtehran.respository.PhotosGalleryRepository
import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery
import com.apollographql.apollo.co.eventbox.tedxtehran.GetAboutsQuery
import com.apollographql.apollo.co.eventbox.tedxtehran.GetAlbumPhotosQuery
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
                values.postValue(null)
            }, {
                values.postValue(it?.organizer()?.abouts())
            })


        }

        return values
    }

}