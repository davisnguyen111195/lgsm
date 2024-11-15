package io.github.logicgatesimu.systems

import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.Family
import com.badlogic.ashley.systems.IteratingSystem
import io.github.logicgatesimu.components.MovementComponent
import io.github.logicgatesimu.components.VelocityComponent

class MovementSystem : IteratingSystem(
    Family.all(MovementComponent::class.java, VelocityComponent::class.java).get()
) {
    private val movementMapper = ComponentMapper.getFor(
        MovementComponent::class.java
    )
    private val velocityMapper = ComponentMapper.getFor(
        VelocityComponent::class.java
    )

    override fun processEntity(entity: Entity?, deltaTime: Float) {
        val position = movementMapper[entity]
        val velocity = velocityMapper[entity]

        position.y += velocity.ySpeed * deltaTime
    }
}
