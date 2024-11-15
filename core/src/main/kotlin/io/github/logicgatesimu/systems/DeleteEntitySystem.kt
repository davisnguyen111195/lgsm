package io.github.logicgatesimu.systems

import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.core.Family
import io.github.logicgatesimu.components.MovementComponent

class DeleteEntitySystem : EntitySystem() {

    private val movementMapper = ComponentMapper.getFor(
        MovementComponent::class.java
    )
    override fun update(deltaTime: Float) {
        super.update(deltaTime)

        engine.getEntitiesFor(Family.all(MovementComponent::class.java).get()).forEach{
            val position = movementMapper[it]

            if(position.y < 0) {
                engine.removeEntity(it)
                println("deleted")
            }
        }
    }
}
