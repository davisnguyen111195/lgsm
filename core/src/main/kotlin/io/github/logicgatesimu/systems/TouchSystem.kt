package io.github.logicgatesimu.systems

import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.core.Family
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.viewport.StretchViewport
import io.github.logicgatesimu.components.TouchComponent

class TouchSystem(val viewPort: StretchViewport) : EntitySystem() {
    private val touchMapper = ComponentMapper.getFor(
        TouchComponent::class.java
    )

    override fun update(deltaTime: Float) {
        super.update(deltaTime)
        if (Gdx.input.isTouched) {
            var vector2 = Vector2(Gdx.input.x.toFloat(), Gdx.input.y.toFloat())
            viewPort.unproject(vector2)
            engine.getEntitiesFor(Family.all(TouchComponent::class.java).get()).forEach {
                val touch = touchMapper[it]
                touch.position?.x = vector2.x
                touch.position?.y = vector2.y
            }
        }
    }
}


