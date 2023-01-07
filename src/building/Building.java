package building;

import elevator.Elevator;

import java.util.ArrayList;
import java.util.List;

public class Building {

    private final List<Floor> floorList = new ArrayList<>();
    private int height = 0;
    private final Elevator buildingElevator;

    public Building(int height) {
        this.height = height;
        this.buildingElevator = new Elevator(this.floorList);
        this.buildFloors();
    }

    private void buildFloors(){
        for (int floor=0;floor!=height;floor++){
            floorList.add(new Floor(floor));
        }
    }

    public List<Floor> getFloorList() {
        return this.floorList;
    }

    public int getHeight() {
        return this.height;
    }

    public Elevator getBuildingElevator() {
        return this.buildingElevator;
    }
}
