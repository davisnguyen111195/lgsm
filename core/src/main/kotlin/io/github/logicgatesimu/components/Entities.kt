package io.github.logicgatesimu.components

import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.math.MathUtils


fun createEntities() : Entity {
    return Entity().apply {
        add(MovementComponent(MathUtils.random() * Gdx.graphics.width, Gdx.graphics.height.toFloat()))
        add(VelocityComponent(0f, MathUtils.random() * -150 - 50))
    }
}
