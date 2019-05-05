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

    private DisplayFragment fallenGuy;

    private Vector<DisplayFragment> guyFragments;

    private Vector<DisplayFragment> hammerFragments;
    private Vector<DisplayFragment> bucketFragments;
    private Vector<DisplayFragment> keyFragments;
    private Vector<DisplayFragment> screwFragments;
    private Vector<DisplayFragment> wrenchFragments;

    public DisplayPainter() {
        guyFragments = new Vector<DisplayFragment>();

        hammerFragments = new Vector<DisplayFragment>();
        bucketFragments = new Vector<DisplayFragment>();
        keyFragments = new Vector<DisplayFragment>();
        screwFragments = new Vector<DisplayFragment>();
        wrenchFragments = new Vector<DisplayFragment>();
    }

    public void setTextureAtlas(TextureAtlas textureAtlas) {
        atlas = textureAtlas;

        fallenGuy = new DisplayFragment();
        fallenGuy.setLocation(707, 882);
        fallenGuy.setTexture(atlas.getTexture("fallenGuy"));

        DisplayFragment guy1 = new DisplayFragment();
        guy1.setLocation(214, 688);
        guy1.setTexture(atlas.getTexture("helmetGuy1"));
        guyFragments.add(guy1);

        DisplayFragment guy2 = new DisplayFragment();
        guy2.setLocation(351, 705);
        guy2.setTexture(atlas.getTexture("helmetGuy2"));
        guyFragments.add(guy2);

        DisplayFragment guy3 = new DisplayFragment();
        guy3.setLocation(555, 703);
        guy3.setTexture(atlas.getTexture("helmetGuy3"));
        guyFragments.add(guy3);

        DisplayFragment guy4 = new DisplayFragment();
        guy4.setLocation(763, 698);
        guy4.setTexture(atlas.getTexture("helmetGuy4"));
        guyFragments.add(guy4);

        DisplayFragment guy5 = new DisplayFragment();
        guy5.setLocation(944, 709);
        guy5.setTexture(atlas.getTexture("helmetGuy5"));
        guyFragments.add(guy5);

        DisplayFragment guy6 = new DisplayFragment();
        guy6.setLocation(1139, 707);
        guy6.setTexture(atlas.getTexture("helmetGuy6"));
        guyFragments.add(guy6);

        DisplayFragment guy7 = new DisplayFragment();
        guy7.setLocation(1402, 717);
        guy7.setTexture(atlas.getTexture("helmetGuy7"));
        guyFragments.add(guy7);

        DisplayFragment hammer1 = new DisplayFragment();
        hammer1.setLocation(412, 267);
        hammer1.setTexture(atlas.getTexture("hammer1"));
        hammerFragments.add(hammer1);

        DisplayFragment hammer2 = new DisplayFragment();
        hammer2.setLocation(410, 355);
        hammer2.setTexture(atlas.getTexture("hammer2"));
        hammerFragments.add(hammer2);

        DisplayFragment hammer3 = new DisplayFragment();
        hammer3.setLocation(410, 426);
        hammer3.setTexture(atlas.getTexture("hammer3"));
        hammerFragments.add(hammer3);

        DisplayFragment hammer4 = new DisplayFragment();
        hammer4.setLocation(410, 503);
        hammer4.setTexture(atlas.getTexture("hammer4"));
        hammerFragments.add(hammer4);

        DisplayFragment hammer5 = new DisplayFragment();
        hammer5.setLocation(413, 570);
        hammer5.setTexture(atlas.getTexture("hammer5"));
        hammerFragments.add(hammer5);


        DisplayFragment bucket1 = new DisplayFragment();
        bucket1.setLocation(576, 248);
        bucket1.setTexture(atlas.getTexture("bucket1"));
        bucketFragments.add(bucket1);

        DisplayFragment bucket2 = new DisplayFragment();
        bucket2.setLocation(570, 351);
        bucket2.setTexture(atlas.getTexture("bucket2"));
        bucketFragments.add(bucket2);

        DisplayFragment bucket3 = new DisplayFragment();
        bucket3.setLocation(573, 443);
        bucket3.setTexture(atlas.getTexture("bucket3"));
        bucketFragments.add(bucket3);

        DisplayFragment bucket4 = new DisplayFragment();
        bucket4.setLocation(572, 527);
        bucket4.setTexture(atlas.getTexture("bucket4"));
        bucketFragments.add(bucket4);

        DisplayFragment bucket5 = new DisplayFragment();
        bucket5.setLocation(568, 613);
        bucket5.setTexture(atlas.getTexture("bucket5"));
        bucketFragments.add(bucket5);

        
        DisplayFragment key1 = new DisplayFragment();
        key1.setLocation(765, 272);
        key1.setTexture(atlas.getTexture("key1"));
        keyFragments.add(key1);

        DisplayFragment key2 = new DisplayFragment();
        key2.setLocation(771, 365);
        key2.setTexture(atlas.getTexture("key2"));
        keyFragments.add(key2);

        DisplayFragment key3 = new DisplayFragment();
        key3.setLocation(765, 439);
        key3.setTexture(atlas.getTexture("key3"));
        keyFragments.add(key3);

        DisplayFragment key4 = new DisplayFragment();
        key4.setLocation(763, 506);
        key4.setTexture(atlas.getTexture("key4"));
        keyFragments.add(key4);

        DisplayFragment key5 = new DisplayFragment();
        key5.setLocation(771, 588);
        key5.setTexture(atlas.getTexture("key5"));
        keyFragments.add(key5);


        DisplayFragment screw1 = new DisplayFragment();
        screw1.setLocation(944,287);
        screw1.setTexture(atlas.getTexture("screw1"));
        screwFragments.add(screw1);

        DisplayFragment screw2 = new DisplayFragment();
        screw2.setLocation(943, 376);
        screw2.setTexture(atlas.getTexture("screw2"));
        screwFragments.add(screw2);

        DisplayFragment screw3 = new DisplayFragment();
        screw3.setLocation(945, 445);
        screw3.setTexture(atlas.getTexture("screw3"));
        screwFragments.add(screw3);

        DisplayFragment screw4 = new DisplayFragment();
        screw4.setLocation(960, 499);
        screw4.setTexture(atlas.getTexture("screw4"));
        screwFragments.add(screw4);

        DisplayFragment screw5 = new DisplayFragment();
        screw5.setLocation(978, 573);
        screw5.setTexture(atlas.getTexture("screw5"));
        screwFragments.add(screw5);


        DisplayFragment wrench1 = new DisplayFragment();
        wrench1.setLocation(1165, 264);
        wrench1.setTexture(atlas.getTexture("wrench1"));
        wrenchFragments.add(wrench1);

        DisplayFragment wrench2 = new DisplayFragment();
        wrench2.setLocation(1189, 342);
        wrench2.setTexture(atlas.getTexture("wrench2"));
        wrenchFragments.add(wrench2);

        DisplayFragment wrench3 = new DisplayFragment();
        wrench3.setLocation(1165, 455);
        wrench3.setTexture(atlas.getTexture("wrench3"));
        wrenchFragments.add(wrench3);

        DisplayFragment wrench4 = new DisplayFragment();
        wrench4.setLocation(1167, 547);
        wrench4.setTexture(atlas.getTexture("wrench4"));
        wrenchFragments.add(wrench4);

        DisplayFragment wrench5 = new DisplayFragment();
        wrench5.setLocation(1168, 622);
        wrench5.setTexture(atlas.getTexture("wrench5"));
        wrenchFragments.add(wrench5);
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
        drawHelmetGuy();
        drawDoor();

        batch.end();
    }

    private void drawScenery() {
        draw("balcony", 44, 230);
        draw("trees", 1339, 287);
        draw("roof", 1334, 519);
    }

    private void drawLanes() {
        /*for (int i = 0; i <= 4; i++) {
            if (controller.getHammerLane().isTurnedOn(i))
                drawHammer(i);

            if (controller.getBucketLane().isTurnedOn(i))
                drawBucket(i);

            if (controller.getKeyLane().isTurnedOn(i))
                drawKey(i);

            if (controller.getScrewLane().isTurnedOn(i))
                drawScrew(i);

            if (controller.getWrenchLane().isTurnedOn(i))
                drawWrench(i);
        }*/



        updateAndDisplayLaneFragment(guyFragments, controller.getGuyLane().positionTable);

        updateAndDisplayLaneFragment(hammerFragments, controller.getHammerLane().positionTable);
        updateAndDisplayLaneFragment(bucketFragments, controller.getBucketLane().positionTable);
        updateAndDisplayLaneFragment(keyFragments, controller.getKeyLane().positionTable);
        updateAndDisplayLaneFragment(screwFragments, controller.getScrewLane().positionTable);
        updateAndDisplayLaneFragment(wrenchFragments, controller.getWrenchLane().positionTable);

        fallenGuy.update(dt);
        if(controller.getGuyPosition() == -1)
            fallenGuy.turnOn();
        else
            fallenGuy.turnOff();
        fallenGuy.draw(batch);
    }

    private void updateAndDisplayLaneFragment(Vector<DisplayFragment> lane, boolean[] positionTable) {
        for(DisplayFragment i : lane) {
            i.update(dt);
        }

        checkLightning(lane, positionTable);

        for(DisplayFragment i : lane)
            i.draw(batch);
    }

    private void drawHammer(int position) {
        switch (position) {
            case 0:
                draw("hammer1", 412, 267);
                break;
            case 1:
                draw("hammer2", 410, 355);
                break;
            case 2:
                draw("hammer3", 410, 426);
                break;
            case 3:
                draw("hammer4", 410, 503);
                break;
            case 4:
                draw("hammer5", 413, 570);
                break;
            default:
                break;
        }
    }

    private void drawBucket(int position) {
        switch (position) {
            case 0:
                draw("bucket1", 576, 248);
                break;
            case 1:
                draw("bucket2", 570, 351);
                break;
            case 2:
                draw("bucket3", 573, 443);
                break;
            case 3:
                draw("bucket4", 572, 527);
                break;
            case 4:
                draw("bucket5", 568, 613);
                break;
            default:
                break;
        }
    }
    private void drawKey(int position) {
        switch (position) {
            case 0:
                draw("key1", 765, 272);
                break;
            case 1:
                draw("key2", 771, 365);
                break;
            case 2:
                draw("key3", 765, 439);
                break;
            case 3:
                draw("key4", 763, 506);
                break;
            case 4:
                draw("key5", 771, 588);
                break;
            default:
                break;
        }
    }
    private void drawScrew(int position) {
        switch (position) {
            case 0:
                draw("screw1", 944, 287);
                break;
            case 1:
                draw("screw2", 943, 376);
                break;
            case 2:
                draw("screw3", 945, 445);
                break;
            case 3:
                draw("screw4", 960, 499);
                break;
            case 4:
                draw("screw5", 978, 573);
                break;
            default:
                break;
        }
    }

    private void drawWrench(int position) {
        switch (position) {
            case 0:
                draw("wrench1", 1165, 264);
                break;
            case 1:
                draw("wrench2", 1189, 342);
                break;
            case 2:
                draw("wrench3", 1165, 455);
                break;
            case 3:
                draw("wrench5", 1167, 547);
                break;
            case 4:
                draw("wrench5", 1168, 622);
                break;
            default:
                break;
        }
    }

    private void drawHelmetGuy() {
        int position = controller.getGuyPosition();

        /*switch (position) {
            case 0:
                draw("helmetGuy1", 214, 688);
                break;
            case 1:
                draw("helmetGuy2", 351, 705);
                break;
            case 2:
                draw("helmetGuy3", 555, 703);
                break;
            case 3:
                draw("helmetGuy4", 763, 698);
                break;
            case 4:
                draw("helmetGuy5", 944, 709);
                break;
            case 5:
                draw("helmetGuy6", 1139, 707);
                break;
            case 6:
                draw("helmetGuy7", 1402, 717);
                break;
            case -1:
                draw("fallenGuy", 707, 882);
                break;
        }*/


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
