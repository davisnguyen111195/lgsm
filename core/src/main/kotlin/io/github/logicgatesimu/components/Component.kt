package io.github.logicgatesimu.components

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer

abstract class Component(
    id: Int,
    inputs: List<Node>,
    output: Node,
    type: String
) {

    val mId = id
    val mInputs = inputs
    val mOutput = output
    val mType = type

    abstract fun evaluate()

    abstract fun draw(batch: SpriteBatch)
    abstract fun draw(shape: ShapeRenderer)

}
