package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class Apple {
    private float width;
    private float height;

    private Random random;

    public float x;
    public float y;

    private int score;

    private Texture apple;

    public Apple(float width, float height){
        this.width = width;
        this.height = height;

        random = new Random();
        score = 0;
        apple = new Texture("apple.png");

        posion(width, height);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Texture getApple(){
        return apple;
    }

    public void posion(float width, float height){
        x = random.nextInt((int) width/16) * 16;
        y = random.nextInt((int) height/16) * 16;
    }

    public void dispose(){
        apple.dispose();
    }
}
