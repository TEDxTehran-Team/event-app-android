package co.eventbox.tedxtehran.utilities

import co.eventbox.tedxtehran.network.APIs

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 7/10/20.
 */


fun String?.toImageURL():String {
    if (this == null) {
        return ""
    }
    if (this.contains("media")){
        return "${APIs.END_POINT}/$this"
    }
    return "${APIs.END_POINT}/media/$this"

}