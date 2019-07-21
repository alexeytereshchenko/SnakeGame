package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.game.SnakeGame;

public class StartScreen implements Screen {

    private SnakeGame game;
    private String text;

    public StartScreen(SnakeGame game){
        this.game = game;
        game.font = new BitmapFont();
        text = "Snake Game";
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.font.getData().setScale(2.7f);

        game.batch.begin();

        game.font.draw(game.batch, text, Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);

        game.batch.end();

        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER) || Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            game.setScreen(new PlayGameFieled(game));
        }else if(Gdx.input.justTouched()){
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
        game.dispose();
    }
}
