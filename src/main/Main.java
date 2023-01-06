package main;

import building.Building;
import building.Floor;

public class Main {
    public static void main(String[] args){
        Building trumpTower = new Building(8);
        Floor floor = trumpTower.getFloorList().get(7);
        System.out.println("poschodie " + floor.getFloorNum());
        //System.out.println("poschodie vytahu " + trumpTower.getBuildingElevator().g);
    }
}
