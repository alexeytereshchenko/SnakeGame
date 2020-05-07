package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.SnakeGame;
import com.mygdx.game.sprites.Apple;

public class GameOver implements Screen {

    private SnakeGame game;
    private BitmapFont font = new BitmapFont(Gdx.files.internal("droidSans.fnt"));
    private Apple apple;

    private GlyphLayout layout;
    
    public GameOver(SnakeGame game, Apple apple){
        this.game = game;
        this.apple = apple;
        
        layout = new GlyphLayout();
        font.getData().setScale(1.0f);
        layout.setText(font, "GAME OVER!", Color.WHITE, Gdx.graphics.getWidth(), Align.center, true);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
	Gdx.gl.glClearColor(0, 0, 0, 0.2f);

	game.batch.begin();

        font.getData().setScale(1.0f);
        font.draw(game.batch, layout, 0, Gdx.graphics.getHeight()/2f);

        game.batch.end();

        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            game.setScreen(new PlayGameFieled(game));
        }

    }
    
    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
