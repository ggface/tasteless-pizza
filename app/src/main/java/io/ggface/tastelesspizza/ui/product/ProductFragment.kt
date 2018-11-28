package io.ggface.tastelesspizza.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.SimpleItemAnimator
import com.squareup.picasso.Picasso
import io.ggface.tastelesspizza.R
import io.ggface.tastelesspizza.pojo.Pizza
import io.ggface.tastelesspizza.pojo.PizzaSize
import io.ggface.tastelesspizza.ui.OnItemClickListener
import io.ggface.tastelesspizza.utils.FormatUtils
import kotlinx.android.synthetic.main.fragment_product.*

/**
 * @author Ivan Novikov on 2017-09-19.
 */
class ProductFragment : Fragment() {

    private lateinit var mAdapter: PizzaSizeAdapter
    private lateinit var mPizza: Pizza

    //region Lifecycle
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initAdapter()
        initRecyclerView()
        Picasso.get().load(FormatUtils.getImageUrl(mPizza))
                .fit().centerCrop()
                .error(R.mipmap.ic_launcher)
                .into(main_image_view)

        product_name_text_view.text = mPizza.name
        product_description_text_view.text = mPizza.description

        crust_traditional_button.setOnClickListener { setCrust(true) }
        rust_thin_button.setOnClickListener { setCrust(false) }

        if (null == savedInstanceState) {
            setCrust(true)
            mAdapter.setItems(mPizza.sizes)
            mAdapter.select(mPizza.getCheapestSize())
            mAdapter.notifyDataSetChanged()

            updateSummary()
        }
    }
    //endregion Lifecycle

    private fun initData() {
        mPizza = activity!!.intent.extras!!.getParcelable(ProductActivity.EXTRA_PIZZA)!!
    }

    private fun initAdapter() {
        mAdapter = PizzaSizeAdapter(object : OnItemClickListener<PizzaSize> {
            override fun onItemClick(element: PizzaSize, position: Int) {
                updateSummary()
            }
        })
    }

    private fun initRecyclerView() {
        val animator = sizes_recycler_view.itemAnimator
        if (animator is SimpleItemAnimator) {
            animator.supportsChangeAnimations = false
        }

        sizes_recycler_view.setHasFixedSize(true)
        sizes_recycler_view.adapter = mAdapter
    }

    private fun setCrust(isTraditional: Boolean) {
        val colorButtonDefault = ContextCompat.getColor(activity!!, R.color.colorPrimary)
        val colorButtonActive = ContextCompat.getColor(activity!!, R.color.colorAccent)
        crust_traditional_button.background.setTint(if (isTraditional) colorButtonActive else colorButtonDefault)
        rust_thin_button.background.setTint(if (!isTraditional) colorButtonActive else colorButtonDefault)
    }

    private fun updateSummary() {
        summary_text_view.text = FormatUtils.price(mPizza.getCheapestSize().price)
    }
}