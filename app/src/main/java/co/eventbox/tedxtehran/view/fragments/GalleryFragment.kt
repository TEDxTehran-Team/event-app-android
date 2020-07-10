package co.eventbox.tedxtehran.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.utilities.gone
import co.eventbox.tedxtehran.view.adapter.GalleryAdapter
import co.eventbox.tedxtehran.viewModel.GalleryViewModel
import kotlinx.android.synthetic.main.fragment_gallery.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-09-26.
 */
class GalleryFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = GalleryAdapter()

        this.recyclerViewGallery.adapter = adapter

        val galleryViewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)
        galleryViewModel.albums().observe(viewLifecycleOwner, Observer {

            this.progressBar.gone()
            adapter.loadedState(it)

        })


    }
}