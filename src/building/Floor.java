package building;

import elevator.Door;

public class Floor {
    private int floorNum;
    private Door floorDoor;

    public Floor(int floorNum) {
        this.floorNum = floorNum;
        this.floorDoor = new Door(this.floorNum);
    }

    public int getFloorNum() {
        return floorNum;
    }

    public Door getFloorDoor() {
        return floorDoor;
    }
}
