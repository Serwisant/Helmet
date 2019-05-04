package com.drill.gw_helmet;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DisplayPainter {
    private TextureAtlas atlas;
    private SpriteBatch batch;
    private Controller controller;

    public DisplayPainter() {

    }

    public void setTextureAtlas(TextureAtlas textureAtlas) {
        atlas = textureAtlas;
    }

    public void setSpriteBatch(SpriteBatch spriteBatch) {
        batch = spriteBatch;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void draw() {
        batch.begin();

        drawLanes();
        drawHelmetGuy();
        drawDoor();

        batch.end();
    }

    private void drawLanes() {
        for (int i = 0; i <= 4; i++) {
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
        }
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

        switch (position) {
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
        }
    }

    private void drawDoor() {
        draw("leftDoor", 85, 647);
        draw("rightDoorFrame", 1508, 647);

        if(controller.isRightDoorOpen())
            draw("rightDoorOpen", 1539, 617);
        else
            draw("rightDoorClosed", 1355, 647);
    }

    private void draw(String textureName, int x, int y) {
        Texture textureToDraw = atlas.getTexture(textureName);
        batch.draw(textureToDraw, x, 1080 - y - textureToDraw.getHeight());
    }
}
