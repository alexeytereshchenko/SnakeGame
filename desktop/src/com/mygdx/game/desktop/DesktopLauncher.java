package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
// import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.SnakeGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Snake Game";
		config.height = 512;
		config.width = 800;
		// config.initialBackgroundColor = Color.BLACK;`
		config.resizable = false;
		
		new LwjglApplication(new SnakeGame(), config);
	}
}
