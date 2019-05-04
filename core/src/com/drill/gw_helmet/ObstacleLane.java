package com.drill.gw_helmet;

public class ObstacleLane extends Lane {
    private Timer timer;
    private boolean shouldAdd;

    public ObstacleLane() {
        super(5);
        timer = new Timer();
        shouldAdd = false;
    }

    public void setTimer(float seconds) {
        timer.setTimer(seconds);
    }

    public void setTimerDelay(float seconds) {
        timer.setDelay(seconds);
    }

    public void update(float deltaTime) {
        if(timer.ticked(deltaTime)) {
            moveDown();
            timer.reset();
        }
    }

    public void add() {
        shouldAdd = true;
    }

    public void moveDown() {
        for(int i = positionTable.length - 1; i > 0; i--) {
            positionTable[i] = positionTable[i-1];
        }

        if(shouldAdd && isTurnedOff(0)) {
            positionTable[0] = true;
            shouldAdd = false;
        }
        else
            positionTable[0] = false;
    }

    public void pause() {
        timer.pause();
    }

    public void resume() {
        timer.resume();
    }
}
