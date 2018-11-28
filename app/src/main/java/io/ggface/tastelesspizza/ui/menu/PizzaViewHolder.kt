package io.ggface.tastelesspizza.ui.menu

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import io.ggface.tastelesspizza.R
import io.ggface.tastelesspizza.pojo.Pizza
import io.ggface.tastelesspizza.ui.OnItemClickListener
import io.ggface.tastelesspizza.utils.FormatUtils
import kotlinx.android.synthetic.main.list_item_pizza.view.*
import org.joda.time.DateTime
import java.util.*

/**
 * ViewHolder for display pizza.
 *
 * @author Ivan Novikov on 2017-09-19.
 */
class PizzaViewHolder(view: View,
                      private val itemClickListener: OnItemClickListener<Pizza>)
    : RecyclerView.ViewHolder(view), View.OnClickListener {

    private var mPizza: Pizza? = null
    private var mTimeInstance = DateTime.now()

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (RecyclerView.NO_POSITION < adapterPosition) {
            mPizza?.let { itemClickListener.onItemClick(it, adapterPosition) }
        }
    }

    fun bindView(pizza: Pizza) {
        mPizza = pizza
        itemView.item_pizza_name_text_view.text = pizza.name
        itemView.item_pizza_price_text_view.text = String.format(Locale.ENGLISH, "from %s", FormatUtils.price(pizza.getCheapestSize().price))
        itemView.item_pizza_description_text_view.text = pizza.description

        Picasso.get().load(getPhotoUrl(pizza))
                .fit().centerCrop()
                .error(R.mipmap.ic_launcher)
                .into(itemView.item_pizza_photo_image_view)
    }

    private fun getPhotoUrl(pizza: Pizza): String {
        return String.format(Locale.ENGLISH, "%s?year=%d&daypos=%d",
                FormatUtils.getImageUrl(pizza), mTimeInstance.year().get(), mTimeInstance.dayOfYear().get())
    }
}