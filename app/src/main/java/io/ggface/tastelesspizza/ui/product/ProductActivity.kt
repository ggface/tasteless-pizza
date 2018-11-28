package io.ggface.tastelesspizza.ui.product

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import com.google.android.material.snackbar.Snackbar
import io.ggface.tastelesspizza.R
import io.ggface.tastelesspizza.pojo.Pizza
import kotlinx.android.synthetic.main.view_toolbar.*

/**
 * @author Ivan Novikov on 2017-09-19.
 */
class ProductActivity : AppCompatActivity() {

    //region Lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        toolbar.inflateMenu(R.menu.menu_common)
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back)
        toolbar.setNavigationOnClickListener { onBackPressed() }

        toolbar.setOnMenuItemClickListener {
            if (R.id.menu_action_order == it.itemId) {
                Snackbar.make(this@ProductActivity.findViewById(android.R.id.content), "Not implemented", Snackbar.LENGTH_SHORT).show()
                return@setOnMenuItemClickListener true
            }
            false
        }
    }
    //endregion Lifecycle

    companion object {

        const val EXTRA_PIZZA = "EXTRA_PIZZA"

        fun start(activity: Activity, pizza: Pizza, sharedImageView: ImageView?) {
            val intent = Intent(activity, ProductActivity::class.java)
            intent.putExtra(EXTRA_PIZZA, pizza)

            if (null != sharedImageView) {
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        activity,
                        sharedImageView,
                        ViewCompat.getTransitionName(sharedImageView)!!)

                activity.startActivity(intent, options.toBundle())
            } else {
                activity.startActivity(intent)
            }
        }
    }
}