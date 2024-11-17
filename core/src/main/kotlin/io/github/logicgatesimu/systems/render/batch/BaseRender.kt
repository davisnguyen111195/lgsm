package io.github.logicgatesimu.systems.render.batch

import com.badlogic.ashley.core.EntitySystem
import com.badlogic.gdx.graphics.g2d.SpriteBatch

abstract class BaseRender : EntitySystem(){
    abstract fun render(batch: SpriteBatch, deltaTime: Float)
}
