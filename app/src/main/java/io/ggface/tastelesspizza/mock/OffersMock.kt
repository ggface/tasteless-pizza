package io.ggface.tastelesspizza.mock

import io.ggface.tastelesspizza.pojo.Offer
import java.util.*

/**
 * @author Ivan Novikov on 2017-09-19.
 */
object OffersMock {

    val all: List<Offer>
        get() {
            val list = ArrayList<Offer>(10)
            for (i in 0..9) {
                list.add(newInstance(i))
            }
            return list
        }

    private fun newInstance(id: Int): Offer {
        return Offer(getTitle(id), getDescription(id), getPromo(id), getColor(id))
    }

    private fun getPromo(id: Int): String {
        return when (id) {
            0 -> "HKQ8080"
            1 -> "J0J0MMM"
            2 -> "GO88BUM"
            else -> ""
        }
    }

    private fun getColor(id: Int): String {
        return when (id) {
            0 -> "#0097A7"
            1 -> "#689F38"
            2 -> "#D84315"
            else -> "#9E9E9E"
        }
    }

    private fun getTitle(id: Int): String {
        return when (id) {
            0 -> "Anniversary Offer 10%"
            1 -> "Half! 50% Discount at the time!"
            2 -> "20% Discount on purchase"
            else -> "EXPIRED"
        }
    }

    private fun getDescription(id: Int): String {
        return when (id) {
            0 -> "Tiger Tiger burning bright, " +
                    "In the forests of the night: " +
                    "What immortal hand or eye, " +
                    "Dare frame thy fearful symmetry?"
            1 -> "When the stars threw down their spears " +
                    "And watered heaven with their tears: " +
                    "Did he smile His work to see? " +
                    "Did he who made the lamb make thee?"
            2 -> "What the hammer? what the chain, " +
                    "In what furnace was thy brain? " +
                    "What the anvil? what dread grasp. " +
                    "Dare its deadly terrors clasp?"
            else -> ""
        }
    }
}