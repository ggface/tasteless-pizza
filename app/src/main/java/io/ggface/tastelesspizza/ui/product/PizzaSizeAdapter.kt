package io.ggface.tastelesspizza.ui.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.ggface.tastelesspizza.R
import io.ggface.tastelesspizza.pojo.PizzaSize
import io.ggface.tastelesspizza.ui.OnItemClickListener
import java.util.*

/**
 * @author Ivan Novikov on 2017-09-19.
 */
class PizzaSizeAdapter(private val mOnItemClickListener: OnItemClickListener<PizzaSize>) : RecyclerView.Adapter<SizeViewHolder>() {

    private var mSelectedPosition = RecyclerView.NO_POSITION
    private var mItems: List<PizzaSize> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SizeViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_size, parent, false)
        return SizeViewHolder(v, object : OnItemClickListener<PizzaSize> {
            override fun onItemClick(element: PizzaSize, position: Int) {
                select(mItems[position])
                mOnItemClickListener.onItemClick(element, position)
            }
        })
    }

    override fun onBindViewHolder(viewHolder: SizeViewHolder, position: Int) {
        val isSelected = position == mSelectedPosition
        viewHolder.bindView(mItems[position], isSelected)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun setItems(items: List<PizzaSize>) {
        mItems = ArrayList(items)
    }

    fun select(pizzaSize: PizzaSize) {
        var position = RecyclerView.NO_POSITION

        for (i in 0 until itemCount) {
            if (pizzaSize == mItems[i]) {
                position = i
                break
            }
        }

        if (RecyclerView.NO_POSITION != mSelectedPosition) {
            notifyItemChanged(mSelectedPosition)
        }

        if (RecyclerView.NO_POSITION != position) {
            mSelectedPosition = position
            notifyItemChanged(position)
        }
    }
}