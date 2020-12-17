package co.eventbox.event.utilities

import co.eventbox.event.network.APIs
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 7/10/20.
 */


fun String?.toImageURL(): String {
    if (this == null) {
        return ""
    }
    if (this.contains("media")) {
        return "${APIs.END_POINT}/$this"
    }
    return "${APIs.END_POINT}/media/$this"

}

fun String?.toPersianDate(): String {

    val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(this!!)

    val calendar = Calendar.getInstance()
    calendar.time = date

    return DateConverter().setGregorianDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).getIranianDate()
}
