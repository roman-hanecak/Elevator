This project contains OOP java implementation of console elevator program for assignment. <br />
<br />
####Author name: Roman Hanečák <br />
####Email: roman.hanecak.1@gmail.com <br />
####Github account: https://github.com/roman-hanecak <br />
####Deadline: 7.1.2023 20:00 <br />
About me: Im fresh graduate of informatics, which looking for coding based job.<br />


####Project structure: <br />
Project consist of 4 packages: Actors, Building, Elevator and Main. <br />
<br />
Package actors contains only 1 class person, which is implemented
for interaction with elevator.<br />
Package building consist of 2 classes: Floor and Building.
Class building is wrapper for preset number of floors and elevator.
<br />
Package elevator has 2 classes Elevator, Announcer, enumerations
Direction and ElevatorState. Last file is interface Movable implemmenting basic methods.

Class Elevator contains whole logic of moving between floors, carrying 
passengers and weight limitation control. <br />
Class Announcer is simply calling what action elevator performs.<br />
Enumerates describes states of elevator, moving or "waiting" and directiong of its movement. <br />

Package main has only 1 class with runnable main.<br />
Class is basic implementation of scenario, where few people operate with elevator.

####Short solution description: <br />
After reading project structure you should know what classes have been implemented :) <br />
Base idea for project is that there is building which consist of floor and elevator. <br />
Every actor calls elevator on their floor independently on each other, with request for moving on their
destination floor. Elevator stores their requests and move customer to their
destination until there are no more requests. <br />

####Elevator algorithm description:<br />
At the beginning elevator stay on ground (floor 0). When actor calls elevator, he makes request for
moving elevator on his current floor. If was elevator empty and actor entered it, then moves on requested destination floor chosen by actor.
In case that elevator is occupied by another actor, elevator will perform request of actor onboard first.
When more actors enters elevator at once it moves to requested floors one by one in the order of actors choices.
Theres function that remove request duplicates when previous actor left elevator on floor where another actor have made request and he entered it.
Then actor is making only next request for destination floor, so elevator wont go on "empty" floor.<br />

Main idea for this implementation is to serve actor first onboard independently how close elevator is to requested floors of another actors.
Elevator informs about his actions by announcer, and recalculate if weight limit wasnt reached whenever actor enter or leave elevator. <br />

####Used technologies:<br />
Java 13 JDK.<br />
IntelliJ idea IDE for project development.<br />
GitHub VCS repository.<br />

####Steps for compilation:





javac -d elevatorC src/elevator/*.java src/building/*.java src/actors/*.java src/main/*.java

java -cp elevatorC {Main}