package actors;

import elevator.Elevator;

public class Person {
    private final int currentFloorNumber;
    private final int destinationFloorNumber;
    private final int weight;

    public Person(int currentFloorNumber, int destinationFloorNumber, int weight) {
        this.currentFloorNumber = currentFloorNumber;
        this.destinationFloorNumber = destinationFloorNumber;
        this.weight = weight;
    }

    public void requestElevator(Elevator elevator){
        elevator.addRequest(this);
    }

    public int getCurrentFloorNumber() {
        return currentFloorNumber;
    }

    public int getDestinationFloorNumber() {
        return destinationFloorNumber;
    }

    public int getWeight() {
        return weight;
    }



}
