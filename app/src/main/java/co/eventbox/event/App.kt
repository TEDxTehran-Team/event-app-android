package co.eventbox.event

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
class App : MultiDexApplication() {

    companion object {
        lateinit var context:Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext

    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }

}