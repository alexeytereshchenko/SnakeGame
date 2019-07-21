package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;

public class GameFieled {
    private Apple apple;
    private Snake snake;

    public GameFieled(Apple apple, Snake snake){
        this.apple = apple;
        this.snake = snake;
    }


    public void checkApple(){

        if (apple.x == snake.x[0] && apple.y == snake.y[0]){
            apple.posion(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            snake.setSnakeLength(snake.getSnakeLength() + 1);
            snake.setTime(snake.getTime() - 3);
            apple.setScore(apple.getScore() + 1);
        }
    }

    public void checkBorder(){

        if (snake.x[0] < 0){
            snake.x[0] = 784;
        }

        if(snake.x[0] >= Gdx.graphics.getWidth()){
            snake.x[0] = 0;
        }

        if (snake.y[0] < 0){
            snake.y[0] = 496;
        }

        if(snake.y[0] >= Gdx.graphics.getHeight()){
            snake.y[0] = 0;
        }
    }

    public boolean checkCollision(){

        for (int i = snake.getSnakeLength(); i > 0; i--) {
            if(snake.x[i] == snake.x[0] && snake.y[i] == snake.y[0]){
                return true;
            }
        }
        return false;
    }

    public void dispose(){
        apple.dispose();
        snake.dispose();
    }
}
