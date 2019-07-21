package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.game.SnakeGame;
import com.mygdx.game.sprites.Apple;

public class GameOver implements Screen {

    private SnakeGame game;
    private BitmapFont font = new BitmapFont();
    private Apple apple;

    public GameOver(SnakeGame game, Apple apple){
        this.game = game;
        this.apple = apple;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        font.draw(game.batch, "game over", Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f);
        font.draw(game.batch, "score: " + (apple.getScore()), 16, 500);

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
