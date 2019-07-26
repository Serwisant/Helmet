package com.drill.gw_helmet;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Vector;

public class DisplayPainter {
    private TextureAtlasWrapper atlas;
    private SpriteBatch batch;
    private Controller controller;
    private float dt;

    private DisplayFragmentContainer dfc;

    public DisplayPainter() {
        dfc = new DisplayFragmentContainer();
    }

    public void setTextureAtlas(TextureAtlasWrapper textureAtlasWrapper) {
        atlas = textureAtlasWrapper;

        dfc.setSpriteAtlas(textureAtlasWrapper);
        dfc.fillContainers();
    }

    public void setSpriteBatch(SpriteBatch spriteBatch) {
        batch = spriteBatch;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void draw(float dt) {
        this.dt = dt;
        batch.begin();

        drawScenery();
        drawLanes();
        drawDoor();
        drawMisses();
        drawPoints();

        batch.end();
    }

    private void drawScenery() {
        draw("Scenery/Balcony", 0, 240);
        draw("Scenery/WorkshopAndTrees", 1248, 290);
        draw("Scenery/Ground", 180, 843);
    }

    private void drawLanes() {
        updateAndDisplayLaneFragment(dfc.getGuyFragments(), controller.getGuyLane().getPositionTable());

        updateAndDisplayLaneFragment(dfc.getHammerFragments(), controller.getHammerLane().getPositionTable());
        updateAndDisplayLaneFragment(dfc.getBucketFragments(), controller.getBucketLane().getPositionTable());
        updateAndDisplayLaneFragment(dfc.getKeyFragments(), controller.getKeyLane().getPositionTable());
        updateAndDisplayLaneFragment(dfc.getScrewFragments(), controller.getScrewLane().getPositionTable());
        updateAndDisplayLaneFragment(dfc.getWrenchFragments(), controller.getWrenchLane().getPositionTable());

        dfc.getFallenGuyFragment().update(dt);
        if(controller.getGuyPosition() == -1)
            dfc.getFallenGuyFragment().turnOn();
        else
            dfc.getFallenGuyFragment().turnOff();
        dfc.getFallenGuyFragment().draw(batch);
    }

    private void drawMisses() {
        for(DisplayFragment i : dfc.getMissFragments())
            i.update(dt);

        if(controller.getMisses() > 0)
            dfc.getMissFragments().elementAt(3).turnOn();
        else
            dfc.getMissFragments().elementAt(3).turnOff();

        switch(controller.getMisses()) {
            case 0:
                dfc.getMissFragments().elementAt(0).turnOff();
                dfc.getMissFragments().elementAt(1).turnOff();
                dfc.getMissFragments().elementAt(2).turnOff();
                break;
            case 1:
                dfc.getMissFragments().elementAt(0).turnOn();
                dfc.getMissFragments().elementAt(1).turnOff();
                dfc.getMissFragments().elementAt(2).turnOff();
                break;
            case 2:
                dfc.getMissFragments().elementAt(0).turnOn();
                dfc.getMissFragments().elementAt(1).turnOn();
                dfc.getMissFragments().elementAt(2).turnOff();
                break;
            case 3:
                dfc.getMissFragments().elementAt(0).turnOn();
                dfc.getMissFragments().elementAt(1).turnOn();
                dfc.getMissFragments().elementAt(2).turnOn();
                break;
        }


        for(DisplayFragment i : dfc.getMissFragments())
            i.draw(batch);
    }

    private void drawPoints() {
        for(DisplayFragment i : dfc.getPointCounterFragments()) {
            i.update(dt);
            i.draw(batch);
        }

        for(DisplayFragment i : dfc.getPointDigitsFragments()) {
            i.update(dt);
            i.draw(batch);
        }

        if(controller.getPoints() < 100) {
            dfc.getPointDigitsFragments().elementAt(0).turnOff();
        } else {
            dfc.getPointDigitsFragments().elementAt(0).turnOn();

            String digitTexture = "GUI/Digit";
            digitTexture += Integer.toString(controller.getPoints() / 100);
            dfc.getPointDigitsFragments().elementAt(0).setSprite(atlas.getSprite(digitTexture));
        }

        if(controller.getPoints() < 10) {
            dfc.getPointDigitsFragments().elementAt(1).turnOff();
        } else {
            dfc.getPointDigitsFragments().elementAt(1).turnOn();

            String digitTexture = "GUI/Digit";
            digitTexture += Integer.toString(controller.getPoints() / 10 % 10);
            dfc.getPointDigitsFragments().elementAt(1).setSprite(atlas.getSprite(digitTexture));
        }

        dfc.getPointDigitsFragments().elementAt(2).turnOn();

        String digitTexture = "GUI/Digit";
        digitTexture += Integer.toString(controller.getPoints() % 10);
        dfc.getPointDigitsFragments().elementAt(2).setSprite(atlas.getSprite(digitTexture));
    }

    private void updateAndDisplayLaneFragment(Vector<DisplayFragment> lane, boolean[] positionTable) {
        for(DisplayFragment i : lane) {
            i.update(dt);
        }

        updateLightning(lane, positionTable);

        for(DisplayFragment i : lane)
            i.draw(batch);
    }

    private void drawDoor() {
        draw("Scenery/LeftDoor", 46, 616);

        if(controller.isRightDoorOpen())
            draw("Door/RightDoorOpen", 1470, 587);
        else
            draw("Door/RightDoorClosed", 1310, 658);
    }

    private void draw(String spriteName, int x, int y) {
        Sprite spriteToDraw = atlas.getSprite(spriteName);
        if (spriteToDraw == null)
            return;
        batch.draw(spriteToDraw, x, 1080 - y - spriteToDraw.getHeight());
    }

    private void updateLightning(Vector<DisplayFragment> array, boolean[] positions) {
        for(int i = 0; i < positions.length; i++)
            if(positions[i])
                array.elementAt(i).turnOn();
            else
                array.elementAt(i).turnOff();
    }
}
