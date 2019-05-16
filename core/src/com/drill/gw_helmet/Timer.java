package com.drill.gw_helmet;

public class Timer {
    private float delay;
    private float timer;
    private float resetValue;
    private boolean paused;

    public Timer() {
        timer = 0;
        delay = 0;
        paused = false;
    }

    public void setDelay(float delay) {
        this.delay = delay;
    }

    public void setTimer(float timer) {
        resetValue = timer;
        reset();
    }

    public void changeTimerWithoutReset(float timer) {
        resetValue = timer;
    }

    public boolean ticked(float deltaTime) {
        if(paused == true)
            return false;

        boolean valueToReturn;

        if(delay > 0.f) {
            delay -= deltaTime;
            return false;
        } else
            timer -= deltaTime;

        if(timer <= 0.f)
            valueToReturn = true;
        else
            valueToReturn = false;

        return valueToReturn;
    }

    public void pause() {
        paused = true;
    }

    public void resume() {
        paused = false;
    }

    public void reset() {
        float remainder = 0;

        if(timer < 0)
            remainder = 0.f - timer;

        timer = resetValue - remainder;
    }
}
