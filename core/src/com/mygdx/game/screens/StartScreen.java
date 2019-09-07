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

public class StartScreen implements Screen {

    private SnakeGame game;
//    private String text;

    private GlyphLayout text;
    
    public StartScreen(SnakeGame game){
        this.game = game;
        game.font = new BitmapFont(Gdx.files.internal("droidSans.fnt"));
//        text = "Snake Game";
//        game.font.getData().setScale(1.0f);
        text = new GlyphLayout();
        text.setText(game.font, "SNAKE GAME", Color.WHITE, Gdx.graphics.getWidth(), Align.center, true);
       
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        game.font.getData().setScale(2.7f);

        game.batch.begin();

//        game.font.draw(game.batch, text, Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
        game.font.getData().setScale(1.0f);
        game.font.draw(game.batch, text, 0, Gdx.graphics.getHeight()/2);

        //fps
        game.font.getData().setScale(0.5f);
        game.font.draw(game.batch, "fps: " + Gdx.graphics.getFramesPerSecond(), Gdx.graphics.getWidth() - 50, Gdx.graphics.getHeight() -20);
        
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
