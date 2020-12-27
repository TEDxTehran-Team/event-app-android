package co.eventbox.event.view.activities

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import co.eventbox.event.R
import co.eventbox.event.utilities.gone
import co.eventbox.event.utilities.setupWithNavController
import co.eventbox.event.utilities.visible
import co.eventbox.event.view.about.AboutUsActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-09-06.
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        locate("en")
        setContentView(R.layout.activity_main)

        val navigations = listOf(
            R.navigation.speakers_navigation,
            R.navigation.current_event_navigation,
            R.navigation.gallery_navigation,
            R.navigation.news_navigation
        )

        bottomNavigation.setupWithNavController(
            navigations,
            supportFragmentManager,
            R.id.fragment_container,
            intent
        )
        imgInfo.setOnClickListener {
            startActivity(Intent(this, AboutUsActivity::class.java))
        }


    }

    fun showBottomNav() {
        bottomNavigation.visible()
    }

    fun hideBottomNav() {
        bottomNavigation.gone()
    }

    fun hideAppBar() {
        appBar.gone()
    }

    fun showAppBar() {
        appBar.visible()
    }

    fun locate(locate: String) {
        val locale = Locale(locate)
        Locale.setDefault(locale)
        val resources: Resources = resources
        val configuration: Configuration = resources.getConfiguration()
        configuration.locale = locale
        resources.updateConfiguration(configuration, resources.getDisplayMetrics())
    }


}
