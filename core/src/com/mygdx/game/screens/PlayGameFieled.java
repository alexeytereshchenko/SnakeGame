package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.SnakeGame;
import com.mygdx.game.sprites.Apple;
import com.mygdx.game.sprites.GameFieled;
import com.mygdx.game.sprites.Snake;

public class PlayGameFieled implements Screen {

    private SnakeGame game;
    private Apple apple;
    private Snake snake;
    private GameFieled gameFieled;

    public PlayGameFieled(SnakeGame game) {
        this.game = game;

        apple = new Apple(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        snake = new Snake();
        gameFieled = new GameFieled(apple, snake);

    }

    @Override
    public void show() {

    }

    private swipelistener swipe = new swipelistener();

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();

        //fps
        game.font.getData().setScale(0.5f);
        game.font.draw(game.batch, "fps: " + Gdx.graphics.getFramesPerSecond(), Gdx.graphics.getWidth() - 50, Gdx.graphics.getHeight() -20);
        
        game.batch.draw(apple.getApple(), apple.x, apple.y, apple.getApple().getWidth(), apple.getApple().getHeight());

        for (int i = 0; i < snake.getSnakeLength(); i++) {
            game.batch.draw(snake.getSnake(), snake.x[i], snake.y[i], snake.getSnake().getWidth(), snake.getSnake().getHeight());
        }

        game.font.getData().setScale(0.5f);
        game.font.draw(game.batch, "score: " + (apple.getScore()), 16, 500);

        game.batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            apple.posion(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            snake.setSnakeLength(snake.getSnakeLength() + 1);
            snake.setTime(snake.getTime() - 5);
            apple.setScore(apple.getScore() + 1);
        }

        gameFieled.checkApple();
        gameFieled.checkBorder();

        snake.pressKey();
        try {
            snake.move();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (gameFieled.checkCollision()) {
            game.setScreen(new GameOver(game, apple));
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
        apple.dispose();
        snake.dispose();
        gameFieled.dispose();
    }
}
