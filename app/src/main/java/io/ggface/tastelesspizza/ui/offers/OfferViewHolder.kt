package io.ggface.tastelesspizza.ui.offers

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.ggface.tastelesspizza.pojo.Offer
import io.ggface.tastelesspizza.ui.OnItemClickListener
import kotlinx.android.synthetic.main.list_item_offer.view.*

/**
 * ViewHolder for display some offers.
 *
 * @author Ivan Novikov on 2017-09-19.
 */
class OfferViewHolder(view: View,
                      private val itemClickListener: OnItemClickListener<Offer>)
    : RecyclerView.ViewHolder(view), View.OnClickListener {

    private var mOffer: Offer? = null

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val position = adapterPosition
        if (RecyclerView.NO_POSITION < position) {
            mOffer.let { itemClickListener.onItemClick(it!!, position) }
        }
    }

    fun bindView(offer: Offer) {
        mOffer = offer
        itemView.item_offer_name_text_view.text = offer.title
        itemView.item_offer_description_text_view.text = offer.description
        itemView.item_offer_photo_image_view.background = ColorDrawable(Color.parseColor(offer.backgroundColor))
    }
}