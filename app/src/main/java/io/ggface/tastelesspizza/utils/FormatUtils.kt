package io.ggface.tastelesspizza.utils

import io.ggface.tastelesspizza.BuildConfig
import io.ggface.tastelesspizza.pojo.Pizza
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.util.*

/**
 * @author Ivan Novikov on 2017-09-19.
 */
object FormatUtils {

    private val PRICE_FORMAT = object : ThreadLocal<NumberFormat>() {
        override fun initialValue(): NumberFormat {
            val symbols = DecimalFormatSymbols()
            symbols.groupingSeparator = ' '
            return DecimalFormat("#.##", symbols)
        }
    }

    fun price(price: BigDecimal?): String {
        val value = if (price == null) "0" else PRICE_FORMAT.get()!!.format(price)
        return String.format(Locale.ENGLISH, "$%s", value)
    }

    fun getImageUrl(pizza: Pizza): String {
        return try {
            String.format(Locale.ENGLISH, "%s/%s%d.png", BuildConfig.IMAGE_URL, "pizza_", pizza.id)
        } catch (e: Exception) {
            ""
        }
    }
}