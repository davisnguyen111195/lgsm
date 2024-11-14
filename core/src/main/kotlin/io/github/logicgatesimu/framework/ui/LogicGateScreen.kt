package io.github.logicgatesimu.framework.ui

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.utils.viewport.StretchViewport
import io.github.logicgatesimu.Main.Companion.WORLD_HEIGHT
import io.github.logicgatesimu.Main.Companion.WORLD_WIDTH

class LogicGateScreen : Screen {
    private lateinit var batch : SpriteBatch
    private lateinit var camera: OrthographicCamera
    private lateinit var viewport: StretchViewport
    private lateinit var shape: ShapeRenderer
    private lateinit var posTouch : Vector2
    private var countTouch : Int = 1
    override fun dispose() {
        batch.dispose()
    }

    override fun show() {
        batch = SpriteBatch()
        camera = OrthographicCamera()
        viewport = StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera)
        shape = ShapeRenderer()
        shape.projectionMatrix.setToOrtho2D(
            0f,
            0f,
            WORLD_WIDTH,
            WORLD_HEIGHT
        )
        batch.projectionMatrix.setToOrtho2D(
            0f,
            0f,
            WORLD_WIDTH,
            WORLD_HEIGHT
        )
        posTouch = Vector2(0f, 0f)
    }



    fun inputTouch() {
        if(Gdx.input.isTouched){
            posTouch.x = Gdx.input.x.toFloat()
            posTouch.y = Gdx.input.y.toFloat()
            posTouch = viewport.unproject(posTouch)
            countTouch++
        }
    }

    override fun render(delta: Float) {
        ScreenUtils.clear(Color.BLACK)
        inputTouch()

        shape.begin(ShapeRenderer.ShapeType.Filled)
        shape.setColor(Color.RED)
        shape.circle(posTouch.x, posTouch.y, 15f)

        shape.end()

    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun hide() {
    }
}
