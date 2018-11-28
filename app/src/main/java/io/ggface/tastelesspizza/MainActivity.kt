package io.ggface.tastelesspizza

import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
import com.google.android.material.snackbar.Snackbar
import io.ggface.tastelesspizza.ui.menu.MenuFragment
import io.ggface.tastelesspizza.ui.offers.OffersFragment
import io.ggface.tastelesspizza.ui.profile.CreateAccountFragment
import io.ggface.tastelesspizza.ui.widget.CountDrawable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_toolbar.*

/**
 * @author Ivan Novikov on 2017-09-19.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var mLastChildTag: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (null == savedInstanceState) {
            mLastChildTag = Tag.MENU.name

            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.content, MenuFragment(), Tag.MENU.name)
            transaction.commitAllowingStateLoss()
        } else {
            mLastChildTag = savedInstanceState.getString(KEY_LAST_CHILD_TAG, Tag.MENU.name)
        }
        bottom_navigation_view.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment?

            val transaction = supportFragmentManager.beginTransaction()
            transaction.setCustomAnimations(R.anim.slide_up, R.anim.slide_down,
                    R.anim.slide_up, R.anim.slide_down)
            transaction.hide(supportFragmentManager.findFragmentByTag(mLastChildTag)!!)

            when (item.itemId) {
                R.id.navigation_menu -> {
                    selectedFragment = obtainFragment(Tag.MENU.name)
                    if (null == selectedFragment) {
                        selectedFragment = MenuFragment()
                        transaction.add(R.id.content, selectedFragment, Tag.MENU.name)
                    } else {
                        transaction.show(selectedFragment)
                    }
                    mLastChildTag = Tag.MENU.name
                }
                R.id.navigation_offers -> {
                    selectedFragment = obtainFragment(Tag.OFFERS.name)
                    if (null == selectedFragment) {
                        selectedFragment = OffersFragment()
                        transaction.add(R.id.content, selectedFragment, Tag.OFFERS.name)
                    } else {
                        transaction.show(selectedFragment)
                    }
                    mLastChildTag = Tag.OFFERS.name
                }
                R.id.navigation_profile -> {
                    selectedFragment = obtainFragment(Tag.PROFILE.name)
                    if (null == selectedFragment) {
                        selectedFragment = CreateAccountFragment()
                        transaction.add(R.id.content, selectedFragment, Tag.PROFILE.name)
                    } else {
                        transaction.show(selectedFragment)
                    }
                    mLastChildTag = Tag.PROFILE.name
                }
                else -> return@OnNavigationItemSelectedListener false
            }
            transaction.commitAllowingStateLoss()
            true
        })

        toolbar.inflateMenu(R.menu.menu_common)
        toolbar.setOnMenuItemClickListener(Toolbar.OnMenuItemClickListener { item ->
            if (R.id.menu_action_order == item.itemId) {
                val snackbar = Snackbar.make(bottom_navigation_view, "Order screen doesn't implemented", Snackbar.LENGTH_SHORT)
                val layout = snackbar.view as Snackbar.SnackbarLayout
                layout.elevation = 0f
                val p = layout.layoutParams as ViewGroup.MarginLayoutParams
                val targetMargin = (bottom_navigation_view.measuredHeight - bottom_navigation_view.translationY).toInt()
                p.setMargins(p.leftMargin, p.topMargin, p.rightMargin, targetMargin)
                snackbar.show()
                bottom_navigation_view.elevation
                return@OnMenuItemClickListener true
            }
            false
        })

        updateOrderCounter(8)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_LAST_CHILD_TAG, mLastChildTag)
    }

    private fun updateOrderCounter(count: Int) {
        val icon = toolbar!!.menu.findItem(R.id.menu_action_order).icon as LayerDrawable

        val badge: CountDrawable

        // Reuse drawable if possible
        val reuse = icon.findDrawableByLayerId(R.id.ic_order_count)
        if (reuse != null && reuse is CountDrawable) {
            badge = reuse
        } else {
            badge = CountDrawable(this)
        }

        badge.setCount(count.toString())
        icon.mutate()
        icon.setDrawableByLayerId(R.id.ic_order_count, badge)
    }

    private fun obtainFragment(tag: String): Fragment? {
        return supportFragmentManager.findFragmentByTag(tag)
    }

    enum class Tag {
        MENU,       // Pizzas screen
        OFFERS,     // Offers screen
        PROFILE     // Profile screen
    }

    companion object {
        private const val KEY_LAST_CHILD_TAG = "KEY_LAST_CHILD_TAG"
    }
}