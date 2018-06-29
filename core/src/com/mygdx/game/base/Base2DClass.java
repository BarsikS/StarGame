package com.mygdx.game.base;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.math.MatrixUtils;
import com.mygdx.game.math.Rect;

public class Base2DClass implements Screen, InputProcessor{
    protected SpriteBatch batch;
    private Rect screenBounds; //границы экрана в пикселях
    private Rect worldBounds; //границы проекции мировых координат
    private Rect glBounds;
    protected Matrix4 worldToGL;
    protected Matrix3 screenToWorld;

    private Vector2 touch = new Vector2();

    protected Game game;

    public Base2DClass(Game game) {
        this.game = game;
        this.screenBounds = new Rect();
        this.worldBounds = new Rect();
        this.glBounds = new Rect(0,0,1f,1f);
        this.worldToGL = new Matrix4();
        this.screenToWorld = new Matrix3();
        Gdx.input.setInputProcessor(this);
        batch = new SpriteBatch();
        batch.getProjectionMatrix().idt();
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

        screenBounds.setSize(width, height);
        screenBounds.setLeft(0);
        screenBounds.setBottom(0);

        float a = width/(float)height;
        worldBounds.setHeight(42f);
        worldBounds.setWidth(42f * a);
        MatrixUtils.calcTransitionMatrix(worldToGL, worldBounds, glBounds);
        batch.setProjectionMatrix(worldToGL);

        MatrixUtils.calcTransitionMatrix(screenToWorld, screenBounds, worldBounds);
        resize(worldBounds);
    }

    public void resize(Rect worldBounds) {
        System.out.println("resize..." + worldBounds.getWidth() + " " + worldBounds.getHeight());
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
        batch.dispose();
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
        touch.set(screenX, screenBounds.getHeight() - screenY).mul(screenToWorld);
        touchDown(touch, pointer);
        return false;
    }

    public void touchDown(Vector2 touch, int pointer) {
        System.out.println("touchDown..." + touch.x + " " + touch.y);
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, screenBounds.getHeight() - screenY).mul(screenToWorld);
        touchUp(touch, pointer);
        return false;
    }

    public void touchUp(Vector2 touch, int pointer) {
        System.out.println("touchDown..." + touch.x + " " + touch.y);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {

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
