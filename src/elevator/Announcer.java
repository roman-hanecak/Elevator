package elevator;

public class Announcer {

    public Announcer() {
    }

    public void callOverWeight(){
        System.out.println("Elevator is overloaded! Please exit elevator.");
    }

    public void showActualFloor( Elevator elevator){
        System.out.println("Actual floor is " + elevator.getCurrentFloor());
    }

    public void stoppedAtFloor( Elevator elevator){
        System.out.println("Elevator has stopped on " + elevator.getCurrentFloor() + ". floor.");
    }

    public void movingUp(){
        System.out.println("Elevator moving upward.");
    }
    public void movingDown(){
        System.out.println("Elevator moving down.");
    }

    public void poepleLeft() {
        System.out.println("Person left elevator.");
    }
    public void peopleEntered() {
        System.out.println("Person entered elevator.");
    }

}
