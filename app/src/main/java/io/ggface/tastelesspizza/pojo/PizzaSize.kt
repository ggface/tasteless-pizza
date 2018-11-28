package io.ggface.tastelesspizza.pojo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

/**
 * @author Ivan Novikov on 2017-09-19.
 */
@Parcelize
data class PizzaSize(val title: String,
                     val weight: Int,
                     val price: BigDecimal,
                     val isPriority: Boolean = false) : Parcelable, Comparable<PizzaSize> {

    override fun compareTo(other: PizzaSize): Int {
        return this.price.compareTo(other.price)
    }
}