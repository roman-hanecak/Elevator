package elevator;

import actors.Person;
import building.Floor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Elevator implements Movable {

    private final int weightLimit = 400;
    private int weight;
    private int currentFloor;
    private ElevatorState elevatorState;
    private Direction elevatorDirection;
    private final List<Integer> floorsRequested;
    private  List<Floor> floorList;
    private final Announcer elevatorAnnouncer;

    private final List<Person> elevatorRequests;

    public Elevator(List<Floor> floorList) {
        this.elevatorState = ElevatorState.WAITING;
        this.elevatorDirection = Direction.NONE;
        this.floorList = floorList;
        this.floorsRequested = new ArrayList<>();
        this.currentFloor = 0;
        this. weight = 0;
        this.elevatorAnnouncer = new Announcer();
        this.elevatorRequests = new ArrayList<>();
    }

    public void addRequest(Person person){
        this.elevatorRequests.add(person);
    }

    public void removeRequests(){
        this.elevatorRequests.clear();
    }

    public void enteredByPerson(Person person){
        this.weight += person.getWeight();
        person.setHasEntered(true);
        this.elevatorAnnouncer.peopleEntered();
    }

    public void leavedByPerson(Person person){
        this.weight -= person.getWeight();
        person.setHasEntered(false);
        this.elevatorRequests.remove(person);
        this.elevatorAnnouncer.poepleLeft();
    }


    public void processRequests(){
        for (Person person: elevatorRequests) {
            this.floorsRequested.add(person.getCurrentFloorNumber());
            this.floorsRequested.add(person.getDestinationFloorNumber());
        }
        this.removeRequestDuplicates();
    }

    public void moveElevator() throws InterruptedException {
        for (Integer floorRequested: floorsRequested) {
            if (isOverWeight()) {
                this.elevatorState = ElevatorState.OVERLOADED;
                elevatorAnnouncer.callOverWeight();
                return;
            }else if(elevatorRequests.size() == 0){
                break;
            }
            this.moveToFloor(floorRequested);
            for (Person person : elevatorRequests) {
                if (getCurrentFloor() == person.getCurrentFloorNumber() && !person.hasEntered()) {
                    if(this.isMoving()){
                        this.stop();
                    }
                    this.enteredByPerson(person);
                }
            }

            List<Person> personsToLeave = new ArrayList<>();
            for (Person person : elevatorRequests) {
                if (getCurrentFloor() == person.getDestinationFloorNumber() && person.hasEntered()) {
                    if(this.isMoving()){
                        this.stop();
                    }
                    personsToLeave.add(person);
                }
            }
            for (Person person: personsToLeave){
                this.leavedByPerson(person);
            }

        }
        this.floorsRequested.clear();
        this.removeRequests();
    }

    public boolean isOverWeight(){
        return this.weight > this.weightLimit;
    }

    public void moveToFloor(int floorNumber){
        while(getCurrentFloor() != floorNumber){
            switch (checkDirection(floorNumber)) {
                case NONE:
                    break;
                case UP:
                    if (!isMoving()) {
                        elevatorAnnouncer.movingUp();
                    }
                    this.moveUp();
                    break;
                case DOWN:
                    if (!isMoving()) {
                        elevatorAnnouncer.movingDown();
                    }
                    this.moveDown();
                    break;
                default:
                    System.out.println("Something bad happened!");
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }

    public Direction checkDirection(int destination){
        if(currentFloor == destination){
            return Direction.NONE;
        }else if(currentFloor < destination){
            return Direction.UP;
        }
        return Direction.DOWN;
    }

    @Override
    public boolean isMoving() {
        return this.elevatorState == ElevatorState.MOVING;
    }

    @Override
    public void moveUp() {
        this.elevatorState = ElevatorState.MOVING;
        this.elevatorDirection = Direction.UP;
        this.currentFloor +=1;
        this.elevatorAnnouncer.showActualFloor(this);
    }

    @Override
    public void moveDown() {
        this.elevatorState = ElevatorState.MOVING;
        this.elevatorDirection = Direction.DOWN;
        this.currentFloor -=1;
        this.elevatorAnnouncer.showActualFloor(this);
    }

    @Override
    public void stop() throws InterruptedException {
        this.elevatorState = ElevatorState.WAITING;
        this.elevatorDirection = Direction.NONE;
        this.elevatorAnnouncer.stoppedAtFloor(this);
        TimeUnit.SECONDS.sleep(1);
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void removeRequestDuplicates(){
        for (int i=0; i<floorsRequested.size()-1; i++){
            if(floorsRequested.get(i).equals(floorsRequested.get(i+1)) ){
                floorsRequested.remove(i);
            }
        }
    }
}
