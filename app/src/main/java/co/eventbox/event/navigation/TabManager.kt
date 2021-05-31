package co.eventbox.event.navigation

import co.eventbox.event.R
import co.eventbox.event.view.activities.MainActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.isInvisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 5/31/21.
 */
class TabManager (private val mainActivity: MainActivity) {

    private val startDestinations = mapOf(
        R.id.speakers to R.id.speakersFragment,
        R.id.event to R.id.ContainerHomeFragment,
        R.id.gallery to R.id.galleryFragment,
        R.id.news to R.id.newsFragment
    )
    private var currentTabId: Int = R.id.speakers
    var currentController: NavController? = null
    private var tabHistory = TabHistory().apply { push(R.id.speakers) }

    val navSpeakersController: NavController by lazy {
        mainActivity.findNavController(R.id.speakerTab).apply {
            graph = navInflater.inflate(R.navigation.navigation_main).apply {
                startDestination = startDestinations.getValue(R.id.speakers)
            }
        }
    }
    private val navCurrentEventController: NavController by lazy {
        mainActivity.findNavController(R.id.currentEventTab).apply {
            graph = navInflater.inflate(R.navigation.navigation_main).apply {
                startDestination = startDestinations.getValue(R.id.event)
            }
        }
    }
    private val navGalleryController: NavController by lazy {
        mainActivity.findNavController(R.id.galleryEventTab).apply {
            graph = navInflater.inflate(R.navigation.navigation_main).apply {
                startDestination = startDestinations.getValue(R.id.gallery)
            }
        }
    }

    private val navNewsController: NavController by lazy {
        mainActivity.findNavController(R.id.newsEventTab).apply {
            graph = navInflater.inflate(R.navigation.navigation_main).apply {
                startDestination = startDestinations.getValue(R.id.news)
            }
        }
    }

    private val speakersTabContainer: View by lazy { mainActivity.speakerTabContainer }
    private val eventTabContainer: View by lazy { mainActivity.currentEventContainer }
    private val galleryTabContainer: View by lazy { mainActivity.galleryContainer }
    private val newsTabContainer: View by lazy { mainActivity.newsContainer }

    fun onSaveInstanceState(outState: Bundle?) {
        outState?.putSerializable(KEY_TAB_HISTORY, tabHistory)
    }

    fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        savedInstanceState?.let {
            tabHistory = it.getSerializable(KEY_TAB_HISTORY) as TabHistory

            switchTab(mainActivity.bottomNavigation.selectedItemId, false)
        }
    }

    fun supportNavigateUpTo(upIntent: Intent) {
        currentController?.navigateUp()
    }

    fun onBackPressed() {
        currentController?.let {
            if (it.currentDestination == null || it.currentDestination?.id == startDestinations.getValue(
                    currentTabId
                )
            ) {
                if (tabHistory.size > 1) {
                    val tabId = tabHistory.popPrevious()
                    switchTab(tabId, false)
                    mainActivity.bottomNavigation.menu.findItem(tabId)?.isChecked = true
                } else {
                    mainActivity.finish()
                }
            }
            it.popBackStack()
        } ?: run {
            mainActivity.finish()
        }
    }

    fun switchTab(tabId: Int, addToHistory: Boolean = true) {
        currentTabId = tabId

        when (tabId) {
            R.id.speakers -> {
                currentController = navSpeakersController
                invisibleTabContainerExcept(speakersTabContainer)
            }
            R.id.event -> {
                currentController = navCurrentEventController
                invisibleTabContainerExcept(eventTabContainer)
            }
            R.id.gallery -> {
                currentController = navGalleryController
                invisibleTabContainerExcept(galleryTabContainer)
            }
            R.id.news -> {
                currentController = navNewsController
                invisibleTabContainerExcept(newsTabContainer)
            }
        }
        if (addToHistory) {
            tabHistory.push(tabId)
        }
    }

    private fun invisibleTabContainerExcept(container: View) {
        eventTabContainer.isInvisible = true
        speakersTabContainer.isInvisible = true
        galleryTabContainer.isInvisible = true
        newsTabContainer.isInvisible = true

        container.isInvisible = false
    }

    companion object {
        private const val KEY_TAB_HISTORY = "key_tab_history"
    }
}