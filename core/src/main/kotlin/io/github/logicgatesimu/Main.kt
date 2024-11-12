package io.github.logicgatesimu

import com.badlogic.gdx.Game
import io.github.logicgatesimu.screens.LogicGateScreen

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms. */
class Main : Game(){
    private lateinit var logicGateScreen: LogicGateScreen
    override fun create() {
        logicGateScreen = LogicGateScreen()
        setScreen(logicGateScreen)
    }

}
