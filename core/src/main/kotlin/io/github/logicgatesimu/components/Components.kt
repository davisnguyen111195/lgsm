package io.github.logicgatesimu.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.math.Vector2

data class MovementComponent(var x: Float = 0f, var y: Float = 0f) : Component

data class VelocityComponent(var xSpeed: Float = 0f, var ySpeed: Float = 0f) : Component

data class TouchComponent(var position: Vector2? = null) : Component
