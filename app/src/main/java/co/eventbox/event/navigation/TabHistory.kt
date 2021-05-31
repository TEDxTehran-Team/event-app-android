package co.eventbox.event.navigation

import java.io.Serializable

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 5/31/21.
 */
class TabHistory : Serializable {

    private val stack: ArrayList<Int> = ArrayList()

    private val isEmpty: Boolean
        get() = stack.size == 0

    val size: Int
        get() = stack.size

    fun push(entry: Int) {
        stack.add(entry)
    }

    fun popPrevious(): Int {
        var entry = -1

        if (!isEmpty) {
            entry = stack[stack.size - 2]
            stack.removeAt(stack.size - 2)
        }
        return entry
    }

    fun clear() {
        stack.clear()
    }
}