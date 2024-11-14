package io.github.logicgatesimu.components

import com.badlogic.gdx.math.Vector2


class Node(
    signal: Boolean = false,
    next: Node? = null,
    position: Vector2
) {

    var mPosition : Vector2 = position
        get() = field
        set(value) {
            field = value
        }
    var mSignal = signal
        get() = field
        set(value) {
            field = value
        }

    var mNext = next
        get() = field
        set(value) {
            field = value
        }

    override fun toString(): String {
        return if (mNext != null) {
            "$mSignal -> ${mNext.toString()}"
        } else {
            "$mSignal"
        }
    }
}
