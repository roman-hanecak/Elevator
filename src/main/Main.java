package main;

import actors.Person;
import building.Building;
import elevator.Elevator;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Building trumpTower = new Building(8);
        Elevator trumpElevator = trumpTower.getBuildingElevator();

        Person jane = new Person(7,0,60);
        Person donald = new Person(4,7,40);
        Person henry = new Person(3,1,70);
        Person steve = new Person(3,7,70);

        jane.requestElevator(trumpElevator);
        donald.requestElevator(trumpElevator);
        henry.requestElevator(trumpElevator);
        steve.requestElevator(trumpElevator);

        trumpElevator.processRequests();
        trumpElevator.moveElevator();
    }
}
