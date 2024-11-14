package io.github.logicgatesimu.core.domain

class OrGate(override val inputs: List<Node>, override val output: Node) : LogicGate() {
    override fun computeOutput(): Boolean {
        output.state = inputs.any() { it.state }
        return output.state
    }
}
