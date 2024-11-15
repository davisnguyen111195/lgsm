package io.github.logicgatesimu.systems

import com.badlogic.ashley.core.EntitySystem
import io.github.logicgatesimu.components.createEntities

class SpawnSystem : EntitySystem() {
    private var timeSinceSpawn = 0f
    override fun update(deltaTime: Float) {
        super.update(deltaTime)
        timeSinceSpawn += deltaTime

        if(timeSinceSpawn > 1f){
            engine.addEntity(createEntities())
            timeSinceSpawn = 0f
        }
    }
}
