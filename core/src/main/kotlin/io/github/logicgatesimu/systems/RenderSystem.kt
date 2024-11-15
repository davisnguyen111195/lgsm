package io.github.logicgatesimu.systems

import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.core.Family
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import io.github.logicgatesimu.components.MovementComponent

class RenderSystem(val shapeRenderer: ShapeRenderer): EntitySystem() {

    private val movementMapper = ComponentMapper.getFor(
        MovementComponent::class.java
    )

    override fun update(deltaTime: Float) {
        super.update(deltaTime)
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled)
        shapeRenderer.color = Color.WHITE

        engine.getEntitiesFor(Family.all(MovementComponent::class.java).get()).forEach {
            val position = movementMapper[it]
            shapeRenderer.circle(position.x, position.y, 10f)
        }

        shapeRenderer.end()
    }
}
