package io.ggface.tastelesspizza.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.ggface.tastelesspizza.R
import io.ggface.tastelesspizza.mock.PizzaMock
import io.ggface.tastelesspizza.pojo.Pizza
import io.ggface.tastelesspizza.ui.DefaultItemDecoration
import io.ggface.tastelesspizza.ui.OnItemClickListener
import io.ggface.tastelesspizza.ui.product.ProductActivity
import kotlinx.android.synthetic.main.fragment_menu.*

/**
 * @author Ivan Novikov on 2017-09-19.
 */
class MenuFragment : Fragment() {

    private lateinit var mAdapter: PizzaAdapter

    //region Lifecycle
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initViews()
        updateMenu()
    }
    //endregion Lifecycle

    private fun initAdapter() {
        mAdapter = PizzaAdapter(object : OnItemClickListener<Pizza> {
            override fun onItemClick(element: Pizza, position: Int) {
                ProductActivity.start(activity!!, element, null)
            }
        })
    }

    private fun initViews() {
        swipe_refresh_layout.setColorSchemeResources(R.color.colorPrimaryDark)
        swipe_refresh_layout.setOnRefreshListener {
            swipe_refresh_layout.isRefreshing = false
            updateMenu()
        }

        menu_recycler_view.addItemDecoration(DefaultItemDecoration(activity!!))
        menu_recycler_view.setHasFixedSize(true)
        menu_recycler_view.adapter = mAdapter
    }

    private fun updateMenu() {
        mAdapter.setItems(PizzaMock.all)
    }
}