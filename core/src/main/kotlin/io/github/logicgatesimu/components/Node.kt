package io.github.logicgatesimu.components


class Node(private var signal: Boolean = false, var next: Node? = null) {

    fun getSignal(): Boolean {
        return signal
    }

    fun setSignal(state: Boolean) {
        signal = state
    }

    override fun toString(): String {
        return if (next != null) {
            "$signal -> ${next.toString()}"
        } else {
            "$signal"
        }
    }
}
