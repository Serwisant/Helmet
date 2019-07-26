package com.drill.gw_helmet;

public class Lane {
    private boolean[] positionTable;

    public Lane(int lenght) {
        positionTable = new boolean[lenght];

        for(boolean i : positionTable)
            i = false;
    }

    public void turnOn(int pos) {
        if(isInvalid(pos))
            return;

        positionTable[pos] = true;
    }

    public void turnOff(int pos) {
        if(isInvalid(pos))
            return;

        positionTable[pos] = false;
    }

    private boolean isInvalid(int pos) {
        return pos < 0 || pos >= positionTable.length;
    }

    public boolean isTurnedOn(int pos) {
        if(isInvalid(pos))
            return false;

        return positionTable[pos];
    }

    public boolean isTurnedOff(int pos) {
        return !isTurnedOn(pos);
    }

    public boolean[] getPositionTable() {
        return positionTable;
    }
}
