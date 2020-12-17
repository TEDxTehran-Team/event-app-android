package co.eventbox.event.utilities

import android.os.Environment

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */


fun cacheDir():String {
    return Environment.getExternalStorageState().toString() + "/Android/data/co.eventbox.tedxtehran/Cache"
}