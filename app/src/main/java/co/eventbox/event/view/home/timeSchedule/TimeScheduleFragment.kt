package co.eventbox.event.view.home.timeSchedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.eventbox.event.R
import co.eventbox.event.utilities.*
import co.eventbox.event.viewModel.TimeScheduleViewModel
import kotlinx.android.synthetic.main.fragment_time_schedule.*
import kotlinx.android.synthetic.main.fragment_time_schedule.empty_state
import kotlinx.android.synthetic.main.fragment_time_schedule.progressBar
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-09-26.
 */
class TimeScheduleFragment : Fragment() {

    private val viewModel: TimeScheduleViewModel by viewModel()

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

        viewModel.daysLiveData.observe(viewLifecycleOwner, {
            this.progressBar.gone()
            if (!it.isNullOrEmpty()) {
                adapter.loadedState(it)
            } else {
                empty_state.visibility = View.VISIBLE
            }
        })


    }
}