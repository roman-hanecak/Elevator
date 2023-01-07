package main;

import actors.Person;
import building.Building;
import building.Floor;
import elevator.Elevator;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Building trumpTower = new Building(8);
        Elevator trumpElevator = trumpTower.getBuildingElevator();

        //Person john = new Person(0,3,110);
        //Person andrew = new Person(0,5,90);

        Person jane = new Person(7,0,60);
        Person donald = new Person(4,7,40);
        Person henry = new Person(3,1,70);
        Person steve = new Person(4,7,70);


        //john.requestElevator(trumpElevator);
        //andrew.requestElevator(trumpElevator);
        jane.requestElevator(trumpElevator);
        donald.requestElevator(trumpElevator);
        henry.requestElevator(trumpElevator);
        steve.requestElevator(trumpElevator);

        trumpElevator.processRequests();
        trumpElevator.moveElevator();
    }
}
