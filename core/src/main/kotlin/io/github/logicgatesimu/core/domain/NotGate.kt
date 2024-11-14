package io.github.logicgatesimu.core.domain

class NotGate(private val input: Node, override val output: Node) : LogicGate() {
    override val inputs : List<Node> = listOf(input)
    override fun computeOutput(): Boolean {
        output.state = !input.state
        return output.state
    }
}
