package elevator;

public class Door implements Openable {
    private int floorNum;
    private DoorState doorState = DoorState.CLOSED;

    public Door(int floorNum) {
        this.floorNum = floorNum;
    }

    public Door() {}

    public int getFloorNum() {
        return floorNum;
    }

    @Override
    public void openDoor() {
        this.doorState = DoorState.OPEN;
    }

    @Override
    public void closeDoor() {
        this.doorState = DoorState.CLOSED;
    }

    @Override
    public boolean isOpened() {
        if(this.doorState == DoorState.CLOSED){
            return false;
        }
        return true;
    }
}
