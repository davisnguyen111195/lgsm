package io.github.logicgatesimu.systems.render.batch

import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Family
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import io.github.logicgatesimu.components.BucketBoundingBoxComponent
import io.github.logicgatesimu.components.TouchComponent

class BucketRenderSystem(private val engine: Engine) : BaseRender() {
    private val touchMapper = ComponentMapper.getFor(
        TouchComponent::class.java
    )

    private val bucketTexture = TextureRegion(Texture("bucket.png"))
    private val bucketMapper = ComponentMapper.getFor(
        BucketBoundingBoxComponent::class.java
    )

    override fun render(batch: SpriteBatch, deltaTime: Float) {
        engine.getEntitiesFor(Family.all(TouchComponent::class.java).get()).forEach { entity ->
            val touchVec = touchMapper[entity]
            val bucket = bucketMapper[entity]

            touchVec.position?.let {
                batch.draw(bucketTexture, it.x, it.y)
                bucket.bucketBoundingBox.x = it.x
                bucket.bucketBoundingBox.y = it.y
                bucket.bucketBoundingBox.width = bucketTexture.texture.width.toFloat()
                bucket.bucketBoundingBox.height = bucketTexture.texture.height.toFloat()
            }

        }
    }
}
