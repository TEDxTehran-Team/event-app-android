package co.eventbox.event.view.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import co.eventbox.event.R
import co.eventbox.event.listener.NewsOnClickListener
import co.eventbox.event.utilities.gone
import co.eventbox.event.utilities.openBrowser
import co.eventbox.event.viewModel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_news.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-09-26.
 */
class NewsFragment : Fragment(), NewsOnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = NewsAdapter(this)
        this.recyclerViewNews.adapter = adapter

        val viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        viewModel.news().observe(viewLifecycleOwner, Observer {
            this.progressBar.gone()
            adapter.loadedState(it)
        })

    }

    override fun onSelected(position: Int, url: String) {
        context?.openBrowser(url)
    }


}