package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.base.Base2DClass;

public class MenuScreen_2_DZ extends Base2DClass {
    SpriteBatch batch;
    Texture img;
    Vector2 touch, pos, v, direct;


    public MenuScreen_2_DZ(Game game) {
        super(game);
    }



    @Override
    public void show() {
        super.show();
        img = new Texture("circle.png");
        batch = new SpriteBatch();
        pos = new Vector2();
        touch = new Vector2(0f,0f);
        v = new Vector2(0f,0f);
        direct = new Vector2(0f, 0f);
    }

    @Override
    public void render (float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        direct.set(touch);
        if (direct.sub(pos).len() > 0.9f) {

            pos.add(v);

        } else {
            pos.set(touch);
        }
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();


    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        v.set(touch.cpy().sub(pos).setLength(2f));
        return false;
    }
}
