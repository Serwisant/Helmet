package com.drill.gw_helmet;

import java.util.Vector;

public class Controller {
    private static float LANE_TIMER = 1.f;

    private Vector<ObstacleLane> obstacleContainer;

    private ObstacleLane hammerLane;
    private ObstacleLane bucketLane;
    private ObstacleLane keyLane;
    private ObstacleLane screwLane;
    private ObstacleLane wrenchLane;

    private Door door;

    private GuyLane guyLane;
    private Timer guyTimer;

    private int score;
    private int partialScore;
    private int misses;

    private Timer toolTimer;

    private float deltaTime;

    public Controller() {
        reset();
    }

    public void reset() {
        misses = 0;

        obstacleContainer = new Vector<ObstacleLane>();

        hammerLane = new ObstacleLane();
        bucketLane = new ObstacleLane();
        keyLane = new ObstacleLane();
        screwLane = new ObstacleLane();
        wrenchLane = new ObstacleLane();

        obstacleContainer.add(hammerLane);
        obstacleContainer.add(bucketLane);
        obstacleContainer.add(keyLane);
        obstacleContainer.add(screwLane);
        obstacleContainer.add(wrenchLane);

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
        partialScore = 0;
        misses = 0;
        deltaTime = 0;
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
        this.deltaTime = deltaTime;

        checkAndHandleDoor();
        updateObstacles();
        countScore();
        increaseSpeedIfNeeded();
        handleCollision();
        checkForToolGenerator();
        updateDoor();
        handleFallenGuy();
    }

    private void checkAndHandleDoor() {
        if(getGuyPosition() == 6) {
            if (guyTimer.ticked(deltaTime)) {
                guyLane.reset();
                door.resume();
                guyTimer.reset();
                score += 5;
            }
            else
                door.pause();
        }
    }

    private void updateObstacles() {
        for(ObstacleLane i : obstacleContainer)
            i.update(deltaTime);
    }

    private void countScore() {
        for(ObstacleLane i : obstacleContainer)
            if(i.didObstacleJustFall())
                partialScore++;

        int scoreToAdd = partialScore/3;
        partialScore = partialScore % 3;
        score += scoreToAdd;

        if(score >= 999)
            score = 999;
    }

    private void increaseSpeedIfNeeded() {
        float speed;

        if(score >= 500)
            speed = 0.3f;
        else if(score >= 200)
            speed = 0.7f;
        else if(score >= 50)
            speed = 0.9f;
        else
            speed = 1.f;

        for(ObstacleLane i : obstacleContainer)
            i.setTimerWithoutReset(speed);
    }

    private void handleCollision() {
        if(getGuyPosition() > 0 && getGuyPosition() < 6) {
            ObstacleLane laneOverGuy = obstacleContainer.get(getGuyPosition() - 1);

            if (canLaneHurt(laneOverGuy)) {
                hitGuy();
                laneOverGuy.turnOff(4);
            }
        }
    }

    private void checkForToolGenerator() {
        if(toolTimer.ticked(deltaTime))
            generateNewTool();
    }

    private void updateDoor() {
        door.update(deltaTime);
    }

    private void handleFallenGuy() {
        if(guyLane.getPosition() == -1) {
            if(guyTimer.ticked(deltaTime)) {
                if(misses >= 4)
                    reset();

                guyLane.reset();

                guyTimer.setTimer(0.5f);
                guyTimer.reset();

                for(ObstacleLane i : obstacleContainer)
                    i.resume();

                door.resume();
            } else {
                for(ObstacleLane i : obstacleContainer)
                    i.pause();
            }
        }
    }

    private boolean canLaneHurt(ObstacleLane lane) {
        return lane.isTurnedOn(4);
    }

    private void hitGuy() {
        guyLane.hit();
        guyTimer.setTimer(1.f);
        misses++;
    }

    private void generateNewTool() {
        int addToLane = (int)(Math.random() * 10) % obstacleContainer.size() + 1;

        if(addToLane >= obstacleContainer.size())
            return;

        obstacleContainer.elementAt(addToLane).add();

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

    public Lane getGuyLane() {
        return guyLane;
    }

    public boolean isRightDoorOpen() {
        return door.isOpen();
    }

    public int getMisses() {
        return misses;
    }

    public int getPoints() {
        return score;
    }
}
