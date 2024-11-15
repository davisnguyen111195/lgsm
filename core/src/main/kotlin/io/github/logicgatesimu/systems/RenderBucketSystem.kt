package io.github.logicgatesimu.systems

import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.core.Family
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import io.github.logicgatesimu.components.TouchComponent

class RenderBucketSystem(val batch: SpriteBatch, val texture: TextureRegion) : EntitySystem() {

    private val touchMapper = ComponentMapper.getFor(
        TouchComponent::class.java
    )


    override fun update(deltaTime: Float) {
        super.update(deltaTime)
        batch.begin()

        engine.getEntitiesFor(Family.all(TouchComponent::class.java).get()).forEach {entity ->
            val touchComponent = touchMapper[entity]
            println("${touchComponent.position?.x}-${touchComponent.position?.y}")
            touchComponent.position?.let {
                println("${it.x}-${it.y}")
                batch.draw(texture, it.x, it.y)
            }
        }
        batch.end()
    }
}
