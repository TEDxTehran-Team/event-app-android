package co.eventbox.event.view.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import co.eventbox.event.R
import co.eventbox.event.listener.PhotoOnClickListener
import co.eventbox.event.utilities.gone
import co.eventbox.event.viewModel.PhotosViewModel
import kotlinx.android.synthetic.main.fragment_albums.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-09-26.
 */
class AlbumsFragment : Fragment(), PhotoOnClickListener {

    private val photosViewModel: PhotosViewModel by viewModel()

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

        photosViewModel.photos(id)
        photosViewModel.photosLiveData.observe(viewLifecycleOwner, {

            if (adapter.itemCount != 0){
                return@observe
            }

            this.progressBar.gone()
            adapter.loadedState(it)

            if (it?.isNullOrEmpty() == true) {
                empty_state.visibility = View.VISIBLE
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