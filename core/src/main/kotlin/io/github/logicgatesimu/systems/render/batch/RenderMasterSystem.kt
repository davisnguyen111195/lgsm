package io.github.logicgatesimu.systems.render.batch

import com.badlogic.ashley.core.EntitySystem
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class RenderMasterSystem(private val batch: SpriteBatch) : EntitySystem() {
    private val renderSystems = mutableListOf<BaseRender>()

    fun addRenderSystem(otherRenderSystem: BaseRender) {
        renderSystems.add(otherRenderSystem)
    }


    override fun update(deltaTime: Float) {
        super.update(deltaTime)
        batch.begin()
        for (system in renderSystems) {
            system.render(batch, deltaTime)
        }

        batch.end()
    }
}
