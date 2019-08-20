package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;


public class swipelistener  {

    public boolean isswipright(){
        if(Gdx.input.isTouched()&&Gdx.input.getDeltaX()>0)
            return true;
        return false;
    }

    public boolean isswipleft(){
        if(Gdx.input.isTouched()&&Gdx.input.getDeltaX()<0)
            return true;
        return false;
    }

    public boolean isswipup(){
        if(Gdx.input.isTouched()&&Gdx.input.getDeltaY()>0)
            return true;
        return false;
    }

    public boolean isswipdown(){
        if(Gdx.input.isTouched()&&Gdx.input.getDeltaX()<0)
            return true;
        return false;
    }

}