package com.mygdx.game.base;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.mygdx.game.math.Rect;

public class Base2DClass implements Screen, InputProcessor{

    private Rect screenBounds; //границы экрана в пикселях
    private Rect worldBounds; //границы проекции мировых координат

    protected Game game;

    public Base2DClass(Game game) {
        this.game = game;
        Gdx.input.setInputProcessor(this);
    }

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
        dispose();
    }

    @Override
    public void dispose() {
        System.out.println("dispose...");
    }

//////////////////////////////////////////////


    @Override
    public boolean keyDown(int keycode) {
        System.out.println("keyDown = " + keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        System.out.println("keyUp = " + keycode);
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        System.out.println("keyTyped = " + character);
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("touchDown = " + screenX + " " + screenY + " "+ pointer + " "+ button + " ");
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        System.out.println("touchUp = " + screenX + " " + screenY + " "+ pointer + " "+ button + " ");
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        System.out.println("touchDragged = " + screenX + " " + screenY + " "+ pointer);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        System.out.println("scrolled = " + amount);
        return false;
    }
}
