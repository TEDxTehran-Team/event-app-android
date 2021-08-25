package co.eventbox.event.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.eventbox.event.model.User
import co.eventbox.event.respository.GalleryRepository
import com.apollographql.apollo.co.eventbox.event.DashboardCacheQuery
import kotlinx.coroutines.launch

/**
 * Created by Mahdi Darvishi.
 * TEDxTehran | Copyrights 8/10/21.
 */

class ProfileViewModel : BaseViewModel() {


    init {
    }
    val _user = MutableLiveData<User>()

    fun setUser(user: User) {
        _user.postValue(user)
    }

}