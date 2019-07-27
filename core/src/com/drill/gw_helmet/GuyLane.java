package com.drill.gw_helmet;

public class GuyLane extends Lane {
    private int currentPosition;
    private Door door;

    public GuyLane() {
        super(7);
        reset();
    }

    public void reset() {
        turnOff(currentPosition);
        currentPosition = 0;
        turnOn(0);
    }

    public int getPosition() {
        return currentPosition;
    }

    public void moveLeft() {
        if(currentPosition == -1)
            return;

        turnOff(currentPosition);

        if(currentPosition > 1 && currentPosition < 6)
            currentPosition--;

        turnOn(currentPosition);
    }

    public void moveRight() {
        if(currentPosition == -1)
            return;

        turnOff(currentPosition);

        if(currentPosition < 5)
            currentPosition++;
        else if(currentPosition == 5 && door.isOpen())
            currentPosition++;

        turnOn(currentPosition);
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public void hit() {
        turnOff(currentPosition);
        currentPosition = -1;
    }
}
