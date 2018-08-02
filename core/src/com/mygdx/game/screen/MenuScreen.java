package com.mygdx.game.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.base.Base2DScreen;
import com.mygdx.game.math.Rect;
import com.mygdx.game.math.Rnd;
import com.mygdx.game.sprite.Background;
import com.mygdx.game.sprite.Star;

import java.util.ArrayList;

/**
 * Экран меню
 */

public class MenuScreen extends Base2DScreen {

    private Background background;
    private Texture bg;
    private TextureAtlas atlas;
    private ArrayList<Star> stars = new ArrayList<Star>();


    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.jpg");
        background = new Background(new TextureRegion(bg));
        atlas = new TextureAtlas("images.atlas");
        TextureRegion starRegion = atlas.findRegion("star");
        for (int i = 0; i < 256; i++)
            stars.add(new Star(starRegion, Rnd.nextFloat(-0.005f, 0f),  Rnd.nextFloat(-2f, -0.1f), Rnd.nextFloat(0.001f, 0.007f)));
        }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    public void update(float delta) {
        for (Star star : stars
                ) {
            star.update(delta);
        }
    }

    public void draw() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        for (Star star : stars
             ) {
            star.draw(batch);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        atlas.dispose();
        super.dispose();
    }

    @Override
    public void touchDown(Vector2 touch, int pointer) {
        super.touchDown(touch, pointer);
    }

    @Override
    public void touchUp(Vector2 touch, int pointer) {
        super.touchUp(touch, pointer);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (Star star : stars
                ) {
            star.resize(worldBounds);
        }
    }
}
