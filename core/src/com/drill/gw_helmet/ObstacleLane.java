package com.drill.gw_helmet;

public class ObstacleLane extends Lane {
    private Timer timer;
    private boolean shouldAdd;
    private boolean justFell;

    public ObstacleLane() {
        super(5);
        timer = new Timer();
        shouldAdd = false;
        justFell = false;
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
        if(isTurnedOn(getPositionTable().length - 1))
            justFell = true;
        else
            justFell = false;

        for(int i = getPositionTable().length - 1; i > 0; i--) {
            if(isTurnedOn(i - 1))
                turnOn(i);
            else
                turnOff(i);
        }

        if(shouldAdd && isTurnedOff(0)) {
            turnOn(0);
            shouldAdd = false;
        }
        else
            turnOff(0);
    }

    public void pause() {
        timer.pause();
    }

    public void resume() {
        timer.resume();
    }

    public boolean didObstacleJustFall() {
        boolean returnValue = justFell;
        justFell = false;
        return returnValue;
    }

    public void setTimerWithoutReset(float speed) {
        timer.changeTimerWithoutReset(speed);
    }
}
