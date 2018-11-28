package io.ggface.tastelesspizza.mock

import io.ggface.tastelesspizza.pojo.Pizza
import io.ggface.tastelesspizza.pojo.PizzaSize
import java.math.BigDecimal
import java.util.*

/**
 * @author Ivan Novikov on 2017-09-19.
 */
object PizzaMock {

    val all: List<Pizza>
        get() {
            val list = ArrayList<Pizza>(10)
            for (i in 0..9) {
                list.add(newInstance(i))
            }
            return list
        }

    private val sizes: List<PizzaSize>
        get() {
            val list = ArrayList<PizzaSize>()
            list.add(PizzaSize("Small", 400, BigDecimal.valueOf(14.49)))
            list.add(PizzaSize("Medium", 550, BigDecimal.valueOf(18.19), true))
            list.add(PizzaSize("Big", 950, BigDecimal.valueOf(23.69)))
            return list
        }

    private fun newInstance(id: Int): Pizza {
        return Pizza(id, getName(id), getDescription(id), sizes)
    }

    private fun getName(id: Int): String {
        return when (id) {
            0 -> "SUPREME PIZZA"
            1 -> "BUFFALO CHICKEN"
            2 -> "MEET COMBO"
            3 -> "PEPPERONI"
            4 -> "Cheese Pizza"
            5 -> "Meat Love"
            6 -> "The Luce"
            7 -> "Fire Breathing Dragon Pizza"
            8 -> "The Bear"
            9 -> "Spanish Chicken"
            else -> ""
        }
    }

    private fun getDescription(id: Int): String {
        return when (id) {
            0 -> "Pepperoni, seasoned pork, beef, mushrooms, green bell peppers and red onions."
            1 -> "Overnight marinated buffalo chicken, ranch, cheddar cheese"
            2 -> "Pepperoni, hamburger, sausage, ham cheddar cheese"
            3 -> "Premium pepperoni"
            4 -> "Classic marinara sauce topped with mozzarella cheese."
            5 -> "Pepperoni, Italian sausage, ham, bacon, seasoned pork and beef."
            6 -> "The pizza that started it all! It's loaded with our Italian sausage, fresh garlic, onion & extra mozzarella on red sauce."
            7 -> "Not to be confused with the \"Black-Pepper-is-too-Spicy-Dragon\" this popular pizza has a kick, and it ain't on the side. Our traditional crust topped with sweet chili sauce and spicy Jerk chicken, mozzarella, smoked Gouda cheese, fresh pineapple salsa and fresh green onion. Vegetarians sub out tofu for the chicken, and vegans sub out tofu for the chicken and vegan cheese for the cheeses."
            8 -> "This is what it feels like to win a meat raffle! This Bear is loaded with Italian sausage, pepperoni, marinated chicken, ground beef and Canadian bacon with mozzarella on red sauce. Not recommended for vegetarians."
            9 -> "Mushroom, smoked Gouda, red onion, marinated chicken, toasted garlic and mozzarella cheese on red sauce."
            else -> ""
        }
    }
}