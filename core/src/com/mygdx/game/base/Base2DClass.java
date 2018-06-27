package com.mygdx.game.base;

import com.badlogic.gdx.Screen;

public class Base2DClass implements Screen{
    @Override
    public void show() {
        System.out.println("show...");
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        System.out.println("resize..." + width + " " + height);
    }

    @Override
    public void pause() {
        System.out.println("pause...");
    }

    @Override
    public void resume() {
        System.out.println("resume...");
    }

    @Override
    public void hide() {
        System.out.println("hide...");
    }

    @Override
    public void dispose() {
        System.out.println("dispose...");
    }
}
