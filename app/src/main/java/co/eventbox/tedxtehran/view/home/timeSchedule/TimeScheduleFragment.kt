package co.eventbox.tedxtehran.view.home.timeSchedule

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.utilities.*
import co.eventbox.tedxtehran.viewModel.HomeViewModel
import co.eventbox.tedxtehran.viewModel.TimeShelduleViewModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_container_home.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_time_schedule.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-09-26.
 */
class TimeScheduleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_time_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = TimeScheduleDayAdapter()
        this.recyclerDays.adapter = adapter

        val viewModel = ViewModelProvider(this).get(TimeShelduleViewModel::class.java)
        viewModel.days().observe(viewLifecycleOwner, Observer {
            this.progressBar.gone()
            if (!it.isEmpty()) {
                adapter.loadedState(it)
                it.forEach {
                    if (it.sessions().size > 0) {
                        return@Observer
                    }
                }
                lottieAnim.visibility = View.VISIBLE
                txtEmptyState.visibility = View.VISIBLE
            }
        })


    }
}