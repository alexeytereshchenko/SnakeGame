package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.StartScreen;

public class SnakeGame extends Game {
	public SpriteBatch batch;
    public BitmapFont font;

	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();

		this.setScreen(new StartScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
	}
}
