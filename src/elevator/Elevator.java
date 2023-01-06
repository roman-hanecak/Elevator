package elevator;

import actors.Person;
import building.Floor;

import java.util.List;

public class Elevator {

    private final int weightLimit = 400;
    private int weight;
    private int currentFloor;
    private ElevatorState elevatorState;
    private List<Floor> floorList;
    private Door elevatorDoors;
    private Announcer elevatorAnnouncer;

    private List<Person> elevatorRequests;

    public Elevator(List<Floor> floorList) {
        this.elevatorState = ElevatorState.WAITING;
        this.floorList = floorList;
        this.elevatorDoors = new Door();
        this.currentFloor = 0;
        this. weight = 0;
        this.elevatorAnnouncer = new Announcer();
    }

    public void addRequest(Person person){
        this.elevatorRequests.add(person);
    }

    public void removeRequest(Person person){
        this.elevatorRequests.remove(0);
    }

    public void enteredByPerson(Person person){
        this.weight += person.getWeight();
    }

    public void leavedByPerson(Person person){
        this.weight -= person.getWeight();
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void processRequests(){
        for (Person person: elevatorRequests) {
            if(isOverWeight()){
                elevatorAnnouncer.callOverWeight();
                return;
            }

        }
    }

    public boolean isOverWeight(){
        return this.weight < this.weightLimit;
    }


}
