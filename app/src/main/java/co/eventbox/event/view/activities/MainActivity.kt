package co.eventbox.event.view.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import co.eventbox.event.Config
import co.eventbox.event.R
import co.eventbox.event.utilities.setupWithNavController
import co.eventbox.event.view.about.AboutUsActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-09-06.
 */

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigations = listOf(
            R.navigation.speakers_navigation,
            R.navigation.current_event_navigation,
            R.navigation.gallery_navigation,
            R.navigation.news_navigation,
            R.navigation.networking_navigation
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


}
