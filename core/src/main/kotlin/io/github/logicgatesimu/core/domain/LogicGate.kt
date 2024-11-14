package io.github.logicgatesimu.core.domain

sealed class LogicGate {
    abstract val inputs: List<Node>
    abstract val output: Node

    abstract fun computeOutput() : Boolean
}
