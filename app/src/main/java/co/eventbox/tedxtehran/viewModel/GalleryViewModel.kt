package co.eventbox.tedxtehran.viewModel

import co.eventbox.tedxtehran.respository.GalleryRepository
import kotlinx.coroutines.launch

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
class GalleryViewModel : BaseViewModel() {

    val galleryRepository = GalleryRepository()


    fun reqeust(){

//        launch {
//            galleryRepository.request()
//        }
    }
}