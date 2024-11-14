@file:JvmName("Lwjgl3Launcher")

package io.github.logicgatesimu.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import io.github.logicgatesimu.Main

/** Launches the desktop (LWJGL3) application. */
fun main() {
    // This handles macOS support and helps on Windows.
    if (StartupHelper.startNewJvmIfRequired())
      return
    Lwjgl3Application(Main(), Lwjgl3ApplicationConfiguration().apply {
        setTitle("logicgatesimu")
        setWindowedMode(1280, 720)
        setWindowIcon(*(arrayOf(128, 64, 32, 16).map { "libgdx$it.png" }.toTypedArray()))
    })
}
