package io.ggface.tastelesspizza.ui

/**
 * List item click listener.
 *
 * @author Ivan Novikov on 2018-09-12.
 */
interface OnItemClickListener<T> {

    /**
     * Notify item was tapped
     *
     * @param element  element
     * @param position adapter position
     */
    fun onItemClick(element: T, position: Int)
}