package actors;

import elevator.Elevator;

public class Person {
    private int floorNumber;
    private int weight;

    public Person(int floorNumber, int weight) {
        this.floorNumber = floorNumber;
        this.weight = weight;
    }

    public void requestElevator(Elevator elevator){
        elevator.addRequest(this);
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getWeight() {
        return weight;
    }

}
