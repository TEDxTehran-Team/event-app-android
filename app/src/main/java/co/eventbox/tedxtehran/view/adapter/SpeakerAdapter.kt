package co.eventbox.tedxtehran.view.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.eventbox.tedxtehran.R
import kotlinx.android.synthetic.main.header_row_speakers_list.view.*
import kotlinx.android.synthetic.main.row_speaker.view.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 6/18/20.
 */

class SpeakerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val ITEM_VIEW_TYPE_HEADER = 0
    private val ITEM_VIEW_TYPE_ROW = 1

    var items: ArrayList<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        if (viewType == ITEM_VIEW_TYPE_HEADER) {
            val view = inflater.inflate(R.layout.header_row_speakers_list, parent, false)
            return HeaderViewHolder(view)
        }

        val view = inflater.inflate(R.layout.row_speaker, parent, false)
        return RowViewHolder(view)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemView = holder.itemView
        when (holder) {
            is RowViewHolder -> {

                itemView.txtTitle.text = items[position]
            }
            is HeaderViewHolder -> {
                itemView.imgBanner.setBackgroundColor(Color.BLUE)
            }
        }
    }


    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return ITEM_VIEW_TYPE_HEADER
        }
        return ITEM_VIEW_TYPE_ROW
    }


    class RowViewHolder(view: View) : RecyclerView.ViewHolder(view)
    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view)
}