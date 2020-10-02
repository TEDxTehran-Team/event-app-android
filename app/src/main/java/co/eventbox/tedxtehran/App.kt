package co.eventbox.tedxtehran

import android.app.Application
import android.content.Context

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
class App : Application() {

    companion object {
        lateinit var context:Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext

    }
}