package io.github.logicgatesimu.core.domain

class AndGate(override val inputs: List<Node>, override val output: Node) : LogicGate() {
    override fun computeOutput(): Boolean {
        output.state = inputs.all { it.state }
        return output.state
    }
}
