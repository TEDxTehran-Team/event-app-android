package co.eventbox.event.view.activities

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import co.eventbox.event.Config
import java.util.*


open class BaseActivity: AppCompatActivity() {

    fun locate(locate: String) {
        val locale = Locale(locate)
        Locale.setDefault(locale)
        val resources: Resources = resources
        val configuration: Configuration = resources.getConfiguration()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLayoutDirection(locale)
        }
        configuration.locale = locale
        if (locate.equals("en")){
            Config.token = "56fe1591-c5c1-4113-aba3-73fca1f5aacd"
        } else if(locate.equals("fa")){
            Config.token = "7b9c5f16-0882-4334-a828-e67ce8ccf201"
        }
        resources.updateConfiguration(configuration, resources.getDisplayMetrics())
    }
}