package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class Snake {
    private Texture snake;

    public float[] x;
    public float[] y;

    private int snakeLength;

    private boolean up;
    private boolean down;
    private boolean right = true;
    private boolean left;

    private int time;

    public Snake(){
        snake = new Texture("snake.png");

        x = new float[10000];
        y = new float[10000];

        time = 50;
        snakeLength = 3;
        defaultPosition();
    }

    public int getSnakeLength() {
        return snakeLength;
    }

    public void setSnakeLength(int snakeLength) {
        this.snakeLength = snakeLength;
    }


    public Texture getSnake() {
        return snake;
    }

    private void defaultPosition(){
        for (int i = 0; i < snakeLength; i++) {
            x[i] = 48-16*i;
            y[i] = 448;
        }
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        if(!(time <= 0)) {
            this.time = time;
        }
    }

    public void move() throws InterruptedException {
        if(up){
            reposition();
            y[0] += 16;
            Thread.sleep(getTime());
        }

        if (down) {
            reposition();
            y[0] -= 16;
            Thread.sleep(getTime());
        }

        if (left) {
            reposition();
            x[0] -= 16;
            Thread.sleep(getTime());
        }

        if (right) {
            reposition();
            x[0] += 16;
            Thread.sleep(getTime());
        }
    }

    public void pressKey(){
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) && !left) {
            right = true;

            left = false;
            up = false;
            down = false;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT) && !right) {
            left = true;

            right = false;
            up = false;
            down = false;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN) && !up) {
            down = true;

            up = false;
            right = false;
            left = false;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.UP) && !down) {
            up = true;

            down = false;
            right = false;
            left = false;
        }
    }

    private void reposition(){
        for (int i = getSnakeLength(); i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
    }

    public void dispose(){
        snake.dispose();
    }


}
