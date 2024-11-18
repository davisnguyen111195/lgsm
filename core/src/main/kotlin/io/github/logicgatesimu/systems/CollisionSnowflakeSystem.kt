package io.github.logicgatesimu.systems

import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.core.Family
import io.github.logicgatesimu.components.BoundingBoxComponent
import io.github.logicgatesimu.components.BucketBoundingBoxComponent

class CollisionSnowflakeSystem : EntitySystem() {

    private val boundingBoxMapper = ComponentMapper.getFor(
        BoundingBoxComponent::class.java
    )

    private val bucketBoundingMapper = ComponentMapper.getFor(
        BucketBoundingBoxComponent::class.java
    )

    override fun update(deltaTime: Float) {
        super.update(deltaTime)
        val entitiesSnow = engine.getEntitiesFor(
            Family.all(
                BoundingBoxComponent::class.java
            ).get()
        )
        engine.getEntitiesFor(Family.all(BucketBoundingBoxComponent::class.java).get()).forEach {
            for (snow in entitiesSnow) {
                if (bucketBoundingMapper[it].bucketBoundingBox.overlaps(boundingBoxMapper[snow].boundingBox)) {
                    engine.removeEntity(snow)
                    println("deleted")
                }
            }
        }

    }
}
