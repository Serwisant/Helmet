package com.drill.gw_helmet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Map;

public class TextureAtlas {
    private Map<String, Texture> textureMap;

    public TextureAtlas() {
        textureMap = new HashMap<String, Texture>();
    }

    public void addTexture(String name, String path) {
        textureMap.put(name, new Texture(Gdx.files.internal(path)));
    }

    public Texture getTexture(String name) {
        return textureMap.get(name);
    }

    public void dispose() {
        for(Map.Entry<String, Texture> entry : textureMap.entrySet())
            entry.getValue().dispose();
    }
}
