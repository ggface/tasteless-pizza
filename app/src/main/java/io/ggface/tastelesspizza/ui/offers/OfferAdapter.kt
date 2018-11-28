package io.ggface.tastelesspizza.ui.offers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.ggface.tastelesspizza.R
import io.ggface.tastelesspizza.pojo.Offer
import io.ggface.tastelesspizza.ui.OnItemClickListener
import java.util.*

/**
 * @author Ivan Novikov on 2017-09-19.
 */
class OfferAdapter(private val itemClickListener: OnItemClickListener<Offer>) : RecyclerView.Adapter<OfferViewHolder>() {

    private var mItems: List<Offer> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_offer, parent, false)
        return OfferViewHolder(v, itemClickListener)
    }

    override fun onBindViewHolder(viewHolder: OfferViewHolder, position: Int) {
        viewHolder.bindView(mItems[position])
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun setItems(offers: List<Offer>) {
        mItems = ArrayList(offers)
    }
}