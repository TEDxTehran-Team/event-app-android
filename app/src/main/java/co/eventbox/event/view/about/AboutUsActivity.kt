package co.eventbox.event.view.about

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import co.eventbox.event.R
import co.eventbox.event.utilities.gone
import co.eventbox.event.viewModel.AboutViewModel
import kotlinx.android.synthetic.main.activity_about_us.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-09-06.
 */

class AboutUsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        val viewModel = ViewModelProvider(this).get(AboutViewModel::class.java)
        val adapter = AboutAdapter()
        this.recyclerAbout.adapter = adapter

            viewModel.abouts().observe(this, Observer {
                adapter.loadedState(it)
                this.progressBar.gone()
        })


        imgBack.setOnClickListener { finish() }

    }
}
