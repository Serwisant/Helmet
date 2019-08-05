package com.drill.gw_helmet;

import java.util.Vector;

public class Controller {
    private float laneTimer = 1.f;

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

    private Timer toolGeneratorTimer;

    private float deltaTime;

    public Controller() {
        reset();
    }

    public void reset() {
        createObstacleLanes();
        createAndFillObstacleLaneContainer();
        createDoor();
        prepareGuyLane();
        prepareGuyTimer();
        prepareToolTimer();
        prepareAllObstacleLanes();
        resetScoreMissesAndDeltaTime();
    }

    private void resetScoreMissesAndDeltaTime() {
        score = 0;
        partialScore = 0;
        misses = 0;
        deltaTime = 0;
    }

    private void createObstacleLanes() {
        hammerLane = new ObstacleLane();
        bucketLane = new ObstacleLane();
        keyLane = new ObstacleLane();
        screwLane = new ObstacleLane();
        wrenchLane = new ObstacleLane();
    }

    private void createAndFillObstacleLaneContainer() {
        obstacleContainer = new Vector<ObstacleLane>();

        obstacleContainer.add(hammerLane);
        obstacleContainer.add(bucketLane);
        obstacleContainer.add(keyLane);
        obstacleContainer.add(screwLane);
        obstacleContainer.add(wrenchLane);
    }

    private void createDoor() {
        door = new Door();
    }

    private void prepareGuyLane() {
        guyLane = new GuyLane();
        guyLane.setDoor(door);
    }

    private void prepareGuyTimer() {
        guyTimer = new Timer();
        guyTimer.setTimer(0.5f);
        guyTimer.reset();
    }

    private void prepareToolTimer() {
        toolGeneratorTimer = new Timer();
        toolGeneratorTimer.setTimer(laneTimer);
    }

    private void prepareAllObstacleLanes() {
        prepareLane(hammerLane, 0.f);
        prepareLane(bucketLane, 0.2f);
        prepareLane(keyLane, 0.4f);
        prepareLane(screwLane, 0.6f);
        prepareLane(wrenchLane, 0.8f);
    }

    private void prepareLane(ObstacleLane lane, float delay) {
        lane.setTimerDelay(delay);
        lane.setTimer(laneTimer);
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
        if(isGuyAtRightDoor()) {
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

    private boolean isGuyAtRightDoor() {
        return getGuyPosition() == 6;
    }

    private void updateObstacles() {
        for(ObstacleLane i : obstacleContainer)
            i.update(deltaTime);
    }

    private void countScore() {
        if(isGuyAtLeftDoor())
            return;
        
        for(ObstacleLane i : obstacleContainer)
            if(i.didObstacleJustFall())
                partialScore++;

        int scoreToAdd = partialScore/3;
        partialScore = partialScore % 3;
        score += scoreToAdd;

        if(score >= 999)
            score = 999;
    }

    private boolean isGuyAtLeftDoor() {
        return guyLane.getPosition() == 0;
    }

    private void increaseSpeedIfNeeded() {
        float speed = laneTimer;

        if(score >= 500)
            speed = 0.3f;
        else if(score >= 200)
            speed = 0.7f;
        else if(score >= 50)
            speed = 0.9f;

        if(speed != laneTimer) {
            laneTimer = speed;
            updateLanesSpeed();
            updateToolGenerationTimer();
        }
    }

    private void updateLanesSpeed() {
        int laneNumber = 0;
        for(ObstacleLane i : obstacleContainer) {
            float laneDelay = laneNumber / obstacleContainer.size() * laneTimer;
            i.setTimerDelay(laneDelay);
            i.setTimerWithoutReset(laneTimer);
            laneNumber++;
        }
    }

    private void updateToolGenerationTimer() {
        toolGeneratorTimer.setTimer(laneTimer);
    }

    private void handleCollision() {
        if(isGuyInField()) {
            ObstacleLane laneOverGuy = obstacleContainer.get(getGuyPosition() - 1);
            if (canLaneHurt(laneOverGuy)) {
                hitGuy();
                laneOverGuy.turnOff(4);
            }
        }
    }

    private boolean isGuyInField() {
        return getGuyPosition() > 0 && getGuyPosition() < 6;
    }

    private void checkForToolGenerator() {
        if(toolGeneratorTimer.ticked(deltaTime))
            generateNewTool();
    }

    private void updateDoor() {
        door.update(deltaTime);
    }

    private void handleFallenGuy() {
        if(isGuyFallen()) {
            if(guyTimer.ticked(deltaTime)) {
                if(isTooMuchMisses())
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

    private boolean isTooMuchMisses() {
        return misses >= 4;
    }

    private boolean isGuyFallen() {
        return guyLane.getPosition() == -1;
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
        int addToLane = (int)(Math.random() * 10) % obstacleContainer.size();

        if(addToLane >= obstacleContainer.size())
            return;

        obstacleContainer.elementAt(addToLane).add();

        toolGeneratorTimer.reset();
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
