package actors;

import elevator.Elevator;

public class Person {
    private final int currentFloorNumber;
    private final int destinationFloorNumber;
    private final int weight;
    private boolean hasEntered;

    public Person(int currentFloorNumber, int destinationFloorNumber, int weight) {
        this.currentFloorNumber = currentFloorNumber;
        this.destinationFloorNumber = destinationFloorNumber;
        this.weight = weight;
        this.hasEntered = false;
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

    public void setHasEntered(boolean hasEntered) {
        this.hasEntered = hasEntered;
    }

    public boolean hasEntered() {
        return hasEntered;
    }
}
