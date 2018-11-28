package io.ggface.tastelesspizza.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import io.ggface.tastelesspizza.R

/**
 * @author Ivan Novikov on 2017-09-19.
 */
class DefaultItemDecoration(context: Context, @ColorInt color: Int? = null) : RecyclerView.ItemDecoration() {

    private var mDivider: Drawable = if (color == null) {
        ContextCompat.getDrawable(context, R.drawable.view_divider_default)!!
    } else {
        ColorDrawable(color)
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)

            val params = child.layoutParams as RecyclerView.LayoutParams

            val top = child.bottom + params.bottomMargin
            val bottom = top + mDivider.intrinsicHeight

            mDivider.setBounds(left, top, right, bottom)
            mDivider.draw(c)
        }
    }
}