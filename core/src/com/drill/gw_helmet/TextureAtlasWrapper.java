package com.drill.gw_helmet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.HashMap;
import java.util.Map;

public class TextureAtlasWrapper {
    private TextureAtlas atlas;

    public TextureAtlasWrapper() {
        atlas = new TextureAtlas(Gdx.files.internal("Assets.atlas"));
    }

    public Sprite getSprite(String name) {
        return atlas.createSprite(name);
    }

    public void dispose() {
        atlas.dispose();
    }
}
