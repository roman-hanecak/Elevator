package elevator;

import building.Floor;

import java.util.List;

public class Elevator {
    private int currentFloor;
    private List<Floor> floorList;

    public Elevator(List<Floor> floorList) {
        this.floorList = floorList;
    }
}
