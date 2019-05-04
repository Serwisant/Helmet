package com.drill.gw_helmet;

public class Door {

    private boolean open;
    private Timer timer;

    public Door() {
        open = true;
        timer = new Timer();
        timer.setTimer(2.f);
    }

    public void update(float deltaTime) {
        if(timer.ticked(deltaTime)) {
            open = !open;
            timer.reset();
        }
    }

    public boolean isOpen() {
        return open;
    }

    public void pause() {
        timer.pause();
    }

    public void resume() {
        timer.resume();
    }
}
