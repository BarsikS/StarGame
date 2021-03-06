package com.mygdx.game.pools;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.mygdx.game.base.SpritesPool;
import com.mygdx.game.sprite.Explosion;

/**
 * Created by Alexey on 14.07.2018.
 */

public class ExplosionPool extends SpritesPool<Explosion> {

    private Sound sound;
    private TextureRegion textureRegion;

    public ExplosionPool(TextureAtlas atlas, Sound sound) {
        this.textureRegion = atlas.findRegion("explosion");
        this.sound = sound;
    }

    @Override
    protected Explosion newObject() {
        return new Explosion(textureRegion, 9, 9, 74, sound);
    }
}
