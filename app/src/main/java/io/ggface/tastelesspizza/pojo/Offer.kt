package io.ggface.tastelesspizza.pojo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author Ivan Novikov on 2017-09-19.
 */
@Parcelize
data class Offer(val title: String,
                 val description: String,
                 val promo: String,
                 val backgroundColor: String) : Parcelable