package io.github.logicgatesimu

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.viewport.StretchViewport
import io.github.logicgatesimu.components.TouchComponent
import io.github.logicgatesimu.components.createEntities
import io.github.logicgatesimu.systems.DeleteEntitySystem
import io.github.logicgatesimu.systems.MovementSystem
import io.github.logicgatesimu.systems.RenderBucketSystem
import io.github.logicgatesimu.systems.RenderSystem
import io.github.logicgatesimu.systems.SpawnSystem
import io.github.logicgatesimu.systems.TouchSystem

class Main : ApplicationAdapter() {
    private lateinit var viewport: StretchViewport
    private lateinit var camera : OrthographicCamera
    private lateinit var engine: Engine
    private lateinit var shapeRenderer: ShapeRenderer
    private lateinit var batch : SpriteBatch
    private lateinit var textureBucket: TextureRegion
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
        engine.addEntity(createEntities())
        engine.addSystem(DeleteEntitySystem())
        engine.addSystem(MovementSystem())
        engine.addSystem(RenderSystem(shapeRenderer))
        val touchComponent = TouchComponent(Vector2(0f, 0f))
        engine.addEntity(Entity().add(touchComponent))
        engine.addSystem(TouchSystem(viewport))
        engine.addSystem(RenderBucketSystem(batch, textureBucket))

        engine.addSystem(SpawnSystem())

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


