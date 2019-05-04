package com.drill.gw_helmet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class Controller {
    private static float LANE_TIMER = 1.f;

    private int misses;
    private ObstacleLane hammerLane;
    private ObstacleLane bucketLane;
    private ObstacleLane keyLane;
    private ObstacleLane screwLane;
    private ObstacleLane wrenchLane;

    private Door door;

    private GuyLane guyLane;
    private Timer guyTimer;
    private int score;

    private Timer toolTimer;

    public Controller() {
        reset();
    }

    public void reset() {
        misses = 0;

        hammerLane = new ObstacleLane();
        bucketLane = new ObstacleLane();
        keyLane = new ObstacleLane();
        screwLane = new ObstacleLane();
        wrenchLane = new ObstacleLane();

        door = new Door();

        guyLane = new GuyLane();
        guyLane.setDoor(door);

        guyTimer = new Timer();
        guyTimer.setTimer(0.5f);
        guyTimer.reset();

        toolTimer = new Timer();
        toolTimer.setTimer(LANE_TIMER);

        prepareLane(hammerLane, 0.f);
        prepareLane(bucketLane, 0.2f);
        prepareLane(keyLane, 0.4f);
        prepareLane(screwLane, 0.6f);
        prepareLane(wrenchLane, 0.8f);

        score = 0;
    }

    private void prepareLane(ObstacleLane lane, float delay) {
        lane.setTimerDelay(delay);
        lane.setTimer(LANE_TIMER);
    }

    public void moveGuyLeft() {
        guyLane.moveLeft();
    }

    public void moveGuyRight() {
        guyLane.moveRight();
    }

    public void update(float deltaTime) {
        if(Gdx.input.justTouched())
            guyLane.moveRight();

        if(getGuyPosition() == 6) {
            if (guyTimer.ticked(deltaTime)) {
                guyLane.reset();
                door.resume();
                guyTimer.reset();
            }
            else
                door.pause();
        }

        hammerLane.update(deltaTime);
        bucketLane.update(deltaTime);
        keyLane.update(deltaTime);
        screwLane.update(deltaTime);
        wrenchLane.update(deltaTime);

        if(toolTimer.ticked(deltaTime))
        {
            generateNewTool();
        }

        door.update(deltaTime);

        switch (getGuyPosition()) {
            case 1:
                if(canLaneHurt(hammerLane))
                    hitGuy();
                hammerLane.turnOff(4);
                break;
            case 2:
                if(canLaneHurt(bucketLane))
                    hitGuy();
                bucketLane.turnOff(4);
                break;
            case 3:
                if(canLaneHurt(keyLane))
                    hitGuy();
                keyLane.turnOff(4);
                break;
            case 4:
                if(canLaneHurt(screwLane))
                    hitGuy();
                screwLane.turnOff(4);
                break;
            case 5:
                if(canLaneHurt(wrenchLane))
                    hitGuy();
                wrenchLane.turnOff(4);
                break;
        }

        if(guyLane.getPosition() == -1)
        {
            if(guyTimer.ticked(deltaTime)) {
                guyLane.reset();

                guyTimer.setTimer(1.f);
                guyTimer.reset();

                hammerLane.resume();
                bucketLane.resume();
                keyLane.resume();
                screwLane.resume();
                wrenchLane.resume();

                door.resume();
            } else {
                hammerLane.pause();
                bucketLane.pause();
                keyLane.pause();
                screwLane.pause();
                wrenchLane.pause();
                door.pause();
            }
        }
    }

    private boolean canLaneHurt(ObstacleLane lane) {
        return lane.isTurnedOn(4);
    }

    private void hitGuy() {
        guyLane.hit();
        guyTimer.setTimer(1.f);
    }

    private void generateNewTool() {
        switch ((int)(Math.random() * 10) % 6) {
            case 0:
                hammerLane.add();
                break;
            case 1:
                bucketLane.add();
                break;
            case 2:
                keyLane.add();
                break;
            case 3:
                screwLane.add();
                break;
            case 4:
                wrenchLane.add();
                break;
            default:
                break;
        }

        toolTimer.reset();
    }

    public ObstacleLane getHammerLane() {
        return hammerLane;
    }

    public ObstacleLane getBucketLane() {
        return bucketLane;
    }

    public ObstacleLane getKeyLane() {
        return keyLane;
    }

    public ObstacleLane getScrewLane() {
        return screwLane;
    }

    public ObstacleLane getWrenchLane() {
        return wrenchLane;
    }

    public int getGuyPosition() {
        return guyLane.getPosition();
    }

    public boolean isRightDoorOpen() {
        return door.isOpen();
    }
}
