package io.github.logicgatesimu

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.viewport.StretchViewport
import io.github.logicgatesimu.components.BoundingBoxComponent
import io.github.logicgatesimu.components.BucketBoundingBoxComponent
import io.github.logicgatesimu.components.TouchComponent
import io.github.logicgatesimu.components.createBucketEntity
import io.github.logicgatesimu.components.createEntities
import io.github.logicgatesimu.systems.CollisionSnowflakeSystem
import io.github.logicgatesimu.systems.DeleteSnowFlakeEntitySystem
import io.github.logicgatesimu.systems.MovementSystem
import io.github.logicgatesimu.systems.render.shape.ShapeRenderSystem
import io.github.logicgatesimu.systems.SpawnSystem
import io.github.logicgatesimu.systems.TouchSystem
import io.github.logicgatesimu.systems.render.batch.BucketRenderSystem
import io.github.logicgatesimu.systems.render.batch.RenderMasterSystem

class Main : ApplicationAdapter() {
    private lateinit var viewport: StretchViewport
    private lateinit var camera: OrthographicCamera
    private lateinit var engine: Engine
    private lateinit var shapeRenderer: ShapeRenderer
    private lateinit var batch: SpriteBatch
    private lateinit var textureBucket: TextureRegion
    private lateinit var bucketBoundingBox: Entity
    override fun create() {
        super.create()
        batch = SpriteBatch()
        textureBucket = TextureRegion(Texture("bucket.png"))
        shapeRenderer = ShapeRenderer()
        engine = Engine()
        camera = OrthographicCamera()
        viewport = StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera)

        shapeRenderer.projectionMatrix.setToOrtho2D(
            0f, 0f,
            WORLD_WIDTH, WORLD_HEIGHT
        )
        batch.projectionMatrix.setToOrtho2D(
            0f, 0f,
            WORLD_WIDTH, WORLD_HEIGHT
        )
        //add entities
        engine.addEntity(createEntities())
        engine.addEntity(createBucketEntity())

        //add system
        engine.addSystem(DeleteSnowFlakeEntitySystem())
        engine.addSystem(MovementSystem())

        engine.addSystem(TouchSystem(viewport))

        val renderMasterSystem = RenderMasterSystem(batch)
        engine.addSystem(renderMasterSystem)
        val bucketRenderSystem = BucketRenderSystem(engine)

        renderMasterSystem.addRenderSystem(bucketRenderSystem)


        engine.addSystem(SpawnSystem())
        engine.addSystem(ShapeRenderSystem(shapeRenderer))
        engine.addSystem(CollisionSnowflakeSystem())
    }

    override fun resize(width: Int, height: Int) {
        super.resize(width, height)
        viewport.update(width, height, true)
    }

    override fun render() {
        super.render()
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        engine.update(Gdx.graphics.deltaTime)
    }

    override fun pause() {
        super.pause()
    }

    override fun resume() {
        super.resume()
    }

    override fun dispose() {
        super.dispose()
        shapeRenderer.dispose()
    }

    companion object {
        const val WORLD_WIDTH = 1280f
        const val WORLD_HEIGHT = 720f
    }

}


