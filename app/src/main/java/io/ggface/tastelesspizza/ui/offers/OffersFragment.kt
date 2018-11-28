package io.ggface.tastelesspizza.ui.offers

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import io.ggface.tastelesspizza.R
import io.ggface.tastelesspizza.mock.OffersMock
import io.ggface.tastelesspizza.pojo.Offer
import io.ggface.tastelesspizza.ui.DefaultItemDecoration
import io.ggface.tastelesspizza.ui.OnItemClickListener
import kotlinx.android.synthetic.main.fragment_offers.*

/**
 * @author Ivan Novikov on 2017-09-19.
 */
class OffersFragment : Fragment() {

    private lateinit var mAdapter: OfferAdapter

    //region Lifecycle
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_offers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter = OfferAdapter(object : OnItemClickListener<Offer> {
            override fun onItemClick(element: Offer, position: Int) {
                Snackbar.make(swipe_refresh_layout, String.format("Promo %s was applied", element.promo), Snackbar.LENGTH_LONG)
                        .setAction("Undo", null)
                        .setActionTextColor(Color.RED)
                        .show()
            }
        })

        swipe_refresh_layout.setOnRefreshListener {
            swipe_refresh_layout.isRefreshing = false
            updateOffers()
        }
        swipe_refresh_layout.setColorSchemeResources(R.color.colorPrimaryDark)

        offers_recycler_view.addItemDecoration(DefaultItemDecoration(activity!!, Color.WHITE))
        offers_recycler_view.setHasFixedSize(true)
        offers_recycler_view.adapter = mAdapter

        updateOffers()
    }
    //endregion Lifecycle

    private fun updateOffers() {
        mAdapter.setItems(OffersMock.all)
        mAdapter.notifyDataSetChanged()
    }
}