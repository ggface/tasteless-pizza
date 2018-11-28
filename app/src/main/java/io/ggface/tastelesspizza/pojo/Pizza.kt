package io.ggface.tastelesspizza.pojo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author Ivan Novikov on 2017-09-19.
 */
@Parcelize
data class Pizza(val id: Int,
                 val name: String,
                 val description: String,
                 val sizes: List<PizzaSize>) : Parcelable {

    fun getCheapestSize(): PizzaSize {
        return sizes.sorted()[0]
    }
}