package co.eventbox.tedxtehran.view.gallery

import android.content.Context
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.listener.PhotoOnClickListener
import co.eventbox.tedxtehran.utilities.loadRadius
import co.eventbox.tedxtehran.utilities.toImageURL
import com.apollographql.apollo.co.eventbox.tedxtehran.GetAlbumPhotosQuery
import ir.farshid_roohi.customadapterrecycleview.AdapterRecyclerView
import kotlinx.android.synthetic.main.row_album.view.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 7/10/20.
 */
class AlbumsAdapter(var listener: PhotoOnClickListener) :
    AdapterRecyclerView<GetAlbumPhotosQuery.Photo>(
        R.layout.row_album,
        R.layout.row_loading,
        R.layout.row_error,
        R.id.btnErrorLoadList
    ) {

    override fun onBindView(
        viewHolder: ItemViewHolder,
        position: Int,
        context: Context,
        element: GetAlbumPhotosQuery.Photo?
    ) {
        val itemView = viewHolder.itemView

        itemView.imgCover.loadRadius(element?.thumbnail()?.toImageURL())
        itemView.layoutRoot.setOnClickListener {
            this.listener.onSelected(position, element?.thumbnail()!!)
        }
    }

}