package io.github.logicgatesimu.components

import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2


fun createEntities(): Entity {
    return Entity().apply {
        add(
            MovementComponent(
                MathUtils.random() * Gdx.graphics.width,
                Gdx.graphics.height.toFloat()
            )
        )
        add(VelocityComponent(0f, MathUtils.random() * -150 - 50))
        add(BoundingBoxComponent(Rectangle(0f, 0f, 0f, 0f)))
    }
}

fun createBucketEntity(): Entity {
    return Entity().apply {
        add(TouchComponent(Vector2(0f, 0f)))
        add(BucketBoundingBoxComponent(Rectangle(0f, 0f, 0f, 0f)))
    }
}
