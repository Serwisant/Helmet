package com.drill.gw_helmet;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import java.util.Vector;

public class DisplayPainter {
    private TextureAtlas atlas;
    private SpriteBatch batch;
    private Controller controller;
    private float dt;

    private DisplayFragmentContainer dfc;

    public DisplayPainter() {
        dfc = new DisplayFragmentContainer();
    }

    public void setTextureAtlas(TextureAtlas textureAtlas) {
        atlas = textureAtlas;

        dfc.setTextureAtlas(textureAtlas);
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
        draw("balcony", 44, 230);
        draw("trees", 1339, 287);
        draw("roof", 1334, 519);
        draw("ground", 214, 905);
    }

    private void drawLanes() {
        updateAndDisplayLaneFragment(dfc.getGuyFragments(), controller.getGuyLane().positionTable);

        updateAndDisplayLaneFragment(dfc.getHammerFragments(), controller.getHammerLane().positionTable);
        updateAndDisplayLaneFragment(dfc.getBucketFragments(), controller.getBucketLane().positionTable);
        updateAndDisplayLaneFragment(dfc.getKeyFragments(), controller.getKeyLane().positionTable);
        updateAndDisplayLaneFragment(dfc.getScrewFragments(), controller.getScrewLane().positionTable);
        updateAndDisplayLaneFragment(dfc.getWrenchFragments(), controller.getWrenchLane().positionTable);

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

            String digitTexture = "digit";
            digitTexture += Integer.toString(controller.getPoints() / 100);
            dfc.getPointDigitsFragments().elementAt(0).setTexture(atlas.getTexture(digitTexture));
        }

        if(controller.getPoints() < 10) {
            dfc.getPointDigitsFragments().elementAt(1).turnOff();
        } else {
            dfc.getPointDigitsFragments().elementAt(1).turnOn();

            String digitTexture = "digit";
            digitTexture += Integer.toString(controller.getPoints() / 10 % 10);
            dfc.getPointDigitsFragments().elementAt(1).setTexture(atlas.getTexture(digitTexture));
        }

        dfc.getPointDigitsFragments().elementAt(2).turnOn();

        String digitTexture = "digit";
        digitTexture += Integer.toString(controller.getPoints() % 10);
        dfc.getPointDigitsFragments().elementAt(2).setTexture(atlas.getTexture(digitTexture));
    }

    private void updateAndDisplayLaneFragment(Vector<DisplayFragment> lane, boolean[] positionTable) {
        for(DisplayFragment i : lane) {
            i.update(dt);
        }

        checkLightning(lane, positionTable);

        for(DisplayFragment i : lane)
            i.draw(batch);
    }

    private void drawDoor() {
        draw("leftDoor", 85, 647);
        draw("rightDoorFrame", 1355, 647);

        if(controller.isRightDoorOpen())
            draw("rightDoorOpen", 1539, 617);
        else
            draw("rightDoorClosed", 1355, 647);
    }

    private void draw(String textureName, int x, int y) {
        Texture textureToDraw = atlas.getTexture(textureName);
        batch.draw(textureToDraw, x, 1080 - y - textureToDraw.getHeight());
    }

    private void checkLightning(Vector<DisplayFragment> array, boolean[] positions) {
        for(int i = 0; i < positions.length; i++)
            if(positions[i])
                array.elementAt(i).turnOn();
            else
                array.elementAt(i).turnOff();
    }
}
