package elevator;

import actors.Person;
import building.Floor;

import java.util.List;

public class Elevator {

    private int weightLimit;
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
        this.weightLimit = 400;
        this.elevatorAnnouncer = new Announcer();
    }

    public void addRequest(Person person){
        this.elevatorRequests.add(person);
    }

}
