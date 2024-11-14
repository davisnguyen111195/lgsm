package io.github.logicgatesimu.core.domain

class Wire(val input: Node, val output: Node) {
    fun transmit(){
        output.state = input.state
    }
}
