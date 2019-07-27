package com.drill.gw_helmet;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DisplayFragment {
    private Sprite sprite;
    private int x;
    private int y;
    private float alpha;
    private float turnOnTime;
    private float turnOffTime;
    private boolean turnedOn;
    private float turnOffAlpha;

    public DisplayFragment() {
        x = 0;
        y = 0;
        alpha = 1.f;
        turnOnTime = 0.05f;
        turnOffTime = 0.05f;
        turnedOn = true;
        turnOffAlpha = 0.1f;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void turnOn() {
        turnedOn = true;
    }

    public void turnOff() {
        turnedOn = false;
    }

    public void update(float deltaTime) {
        if(turnedOn) {
            alpha = alpha + (deltaTime / turnOnTime) < 1.f ? alpha + (deltaTime / turnOnTime) : 1.f;
        } else {
            alpha = alpha - (deltaTime / turnOffTime) > 0.f ? alpha - (deltaTime / turnOffTime) : turnOffAlpha;
        }
    }

    public void draw(SpriteBatch batch) {
        if(sprite == null)
            return;

        sprite.setAlpha(alpha);
        sprite.setPosition(x, 1080 - sprite.getHeight() - y);
        sprite.draw(batch);
    }
}
