package co.eventbox.tedxtehran.view.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.utilities.setupWithNavController
import co.eventbox.tedxtehran.view.about.AboutUsActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-09-06.
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigations = listOf(
            R.navigation.main_event_navigation,
            R.navigation.speakers_navigation,
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
}
