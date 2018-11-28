package io.ggface.tastelesspizza.ui.product

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.ggface.tastelesspizza.pojo.PizzaSize
import io.ggface.tastelesspizza.ui.OnItemClickListener
import io.ggface.tastelesspizza.utils.FormatUtils
import kotlinx.android.synthetic.main.list_item_size.view.*
import java.util.*

/**
 * ViewHolder for display pizzas' sizes.
 *
 * @author Ivan Novikov on 2017-09-19.
 */
class SizeViewHolder(view: View,
                     private val mOnItemClickListener: OnItemClickListener<PizzaSize>)
    : RecyclerView.ViewHolder(view), View.OnClickListener {

    private var mPizzaSize: PizzaSize? = null

    init {
        itemView.item_size_marker_radio_button.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (RecyclerView.NO_POSITION < adapterPosition) {
            mOnItemClickListener.onItemClick(mPizzaSize!!, adapterPosition)
        }
    }

    fun bindView(pizzaSize: PizzaSize, isSelected: Boolean) {
        mPizzaSize = pizzaSize
        itemView.item_size_name_text_view.text = pizzaSize.title
        itemView.item_size_price_text_view.text = FormatUtils.price(pizzaSize.price)
        itemView.item_size_weight_text_view.text = String.format(Locale.ENGLISH, "%sg", pizzaSize.weight)
        itemView.item_size_marker_radio_button.isChecked = isSelected
    }
}
