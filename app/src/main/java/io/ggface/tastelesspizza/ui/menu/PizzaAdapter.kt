package io.ggface.tastelesspizza.ui.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.ggface.tastelesspizza.R
import io.ggface.tastelesspizza.pojo.Pizza
import io.ggface.tastelesspizza.ui.OnItemClickListener
import java.util.*

/**
 * @author Ivan Novikov on 2017-09-19.
 */
class PizzaAdapter(private val itemClickListener: OnItemClickListener<Pizza>) : RecyclerView.Adapter<PizzaViewHolder>() {

    private var mItems: List<Pizza> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_pizza, parent, false)
        return PizzaViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(viewHolder: PizzaViewHolder, position: Int) {
        viewHolder.bindView(mItems[position])
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun setItems(items: List<Pizza>) {
        mItems = ArrayList(items)
        notifyDataSetChanged()
    }
}