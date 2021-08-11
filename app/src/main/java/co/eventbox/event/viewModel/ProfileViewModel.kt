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
        Log.i("test", "hi in viewmodel: ")
    }
    val _user = MutableLiveData<User>()

    fun setUser(user: User) {
        Log.i("test", "setUser:$user ")
        _user.postValue(user)
    }

    fun log() {
        Log.i("test", "log in VM ${_user.value} ")
    }

}