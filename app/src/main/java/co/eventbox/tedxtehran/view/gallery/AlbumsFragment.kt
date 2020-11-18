package co.eventbox.tedxtehran.view.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.listener.PhotoOnClickListener
import co.eventbox.tedxtehran.utilities.gone
import co.eventbox.tedxtehran.utilities.visible
import co.eventbox.tedxtehran.viewModel.GalleryViewModel
import kotlinx.android.synthetic.main.fragment_albums.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-09-26.
 */
class AlbumsFragment : Fragment(), PhotoOnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_albums, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.get("albums_id") as Int

        val adapter = AlbumsAdapter(this)
        this.recyclerViewPhotos.layoutManager = GridLayoutManager(this.context, 3)
        this.recyclerViewPhotos.adapter = adapter

        val galleryViewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)
        galleryViewModel.photos(id).observe(viewLifecycleOwner, Observer {

            this.progressBar.gone()
            adapter.loadedState(it)

            if(it.isEmpty()) {
                lottieAnim.visible()
                txtEmptyState.visible()
            }

        })


    }

    override fun onSelected(position: Int, url: String) {
        findNavController().navigate(
            R.id.action_galleryListFragment_to_photoLargeFragment,
            bundleOf("photo_url" to url)
        )
    }
}