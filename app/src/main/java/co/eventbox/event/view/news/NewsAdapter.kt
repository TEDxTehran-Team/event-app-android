package co.eventbox.event.view.news

import android.content.Context
import co.eventbox.event.R
import co.eventbox.event.listener.NewsOnClickListener
import co.eventbox.event.utilities.load
import co.eventbox.event.utilities.toImageURL
import co.eventbox.event.view.AdapterRecyclerView
import com.apollographql.apollo.co.eventbox.event.DashboardCacheQuery
import kotlinx.android.synthetic.main.row_news.view.*
import kotlinx.android.synthetic.main.row_news.view.txtTitle

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 7/10/20.
 */
class NewsAdapter(var listener: NewsOnClickListener) : AdapterRecyclerView<DashboardCacheQuery.New>(
    R.layout.row_news,
    R.layout.row_loading,
    R.layout.row_error,
    R.id.btnErrorLoadList
) {


    override fun onBindView(
        viewHolder: ItemViewHolder,
        position: Int,
        context: Context,
        element: DashboardCacheQuery.New?
    ) {
        val itemView = viewHolder.itemView


        itemView.txtTitle.text = element?.title()
        itemView.txtDesc.text = element?.description()
        itemView.imgLogo.load(element?.iconUrl().toImageURL(), R.drawable.placeholdertransparent)

        itemView.cardView.setOnClickListener {
            this.listener.onSelected(position, element?.extraLink().toString())
        }
    }


}