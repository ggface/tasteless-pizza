@file: JvmName("PixelUtils")

package io.ggface.tastelesspizza.utils

import android.content.Context
import android.util.TypedValue

/**
 * @author Ivan Novikov on 2017-09-19.
 */
object PixelUtils {

    @JvmStatic
    fun getPixelsFromDp(context: Context, dp: Int): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), context.resources.displayMetrics).toInt()
    }
}