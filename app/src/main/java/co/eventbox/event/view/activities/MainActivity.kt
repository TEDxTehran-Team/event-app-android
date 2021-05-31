package co.eventbox.event.view.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import co.eventbox.event.Config
import co.eventbox.event.R
import co.eventbox.event.navigation.TabManager
import co.eventbox.event.utilities.setupWithNavController
import co.eventbox.event.view.about.AboutUsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-09-06.
 */

class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener  {

    private val tabManager: TabManager by lazy { TabManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        locate(Config.language)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            tabManager.currentController = tabManager.navSpeakersController
            if (intent.containsDeepLink()) {
                handleDeepLink()
            }
        }

        bottomNavigation.setOnNavigationItemSelectedListener(this)

//        val navigations = listOf(
//            R.navigation.speakers_navigation,
//            R.navigation.current_event_navigation,
//            R.navigation.gallery_navigation,
//            R.navigation.news_navigation
//        )
//
//        bottomNavigation.setupWithNavController(
//            navigations,
//            supportFragmentManager,
//            R.id.fragment_container,
//            intent
//        )
        imgInfo.setOnClickListener {
            startActivity(Intent(this, AboutUsActivity::class.java))
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        tabManager.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        tabManager.onRestoreInstanceState(savedInstanceState)
    }

    override fun supportNavigateUpTo(upIntent: Intent) {
        tabManager.supportNavigateUpTo(upIntent)
    }

    override fun onBackPressed() {
        tabManager.onBackPressed()
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        tabManager.switchTab(menuItem.itemId)
        return true
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
        if (this.intent.containsDeepLink()) {
            handleDeepLink()
        }
    }

    private fun handleDeepLink() {
        intent.data?.pathSegments?.also { deepLinkPathSegments ->
            when(deepLinkPathSegments.firstOrNull()?.trim()) {
                "speakers" -> R.id.speakers
                "currentEvent" ->  R.id.event
                "gallery" -> R.id.gallery
                "news" -> R.id.news
                "pages" -> {
//                    tabManager.currentController?.navigate(NavigationGraphMainDirections.actionGlobalPageFragment(getPageNumberFromSegments(deepLinkPathSegments), "PageFragment"))
                    null
                }
                else -> null
            }?.also {
                tabManager.switchTab(it)
                bottomNavigation.menu.findItem(it).isChecked = true
            }
        }
    }

    private fun getPageNumberFromSegments(deepLinkPathSegments: List<String>): Int = if (deepLinkPathSegments.size < 2) 0 else deepLinkPathSegments[1].toIntOrNull() ?: 0

    private fun Intent.containsDeepLink(): Boolean = action == Intent.ACTION_VIEW && data != null


}
