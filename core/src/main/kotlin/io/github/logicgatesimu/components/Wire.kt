package io.github.logicgatesimu.components

import com.badlogic.gdx.graphics.g2d.SpriteBatch

//
class Wire(
    id: Int,
    input: Node,
    output: Node,
    type: String = "wire"
) : Component(
    id,
    listOf(input),
    output,
    type
) {
    init {
        mOutput.mNext = mInputs[0]
    }

    override fun evaluate() {
        mOutput.mSignal = mOutput.mNext?.mSignal ?: false
    }

    override fun draw(batch: SpriteBatch) {
    }

}