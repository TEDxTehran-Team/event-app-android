package co.eventbox.event.view.gallery

import android.content.Context
import co.eventbox.event.R
import co.eventbox.event.listener.PhotoOnClickListener
import co.eventbox.event.utilities.loadRadius
import co.eventbox.event.utilities.toImageURL
import com.apollographql.apollo.co.eventbox.event.GetAlbumPhotosQuery
import kotlinx.android.synthetic.main.row_album.view.*
import co.eventbox.event.view.AdapterRecyclerView


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