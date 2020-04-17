package co.eventbox.tedxtehran.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
open class BaseViewModel : ViewModel(), CoroutineScope {


    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO
}