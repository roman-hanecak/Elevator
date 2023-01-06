package elevator;

public interface Movable {
    boolean isMoving();
    void moveUp();
    void moveDown();
    void stop();
}
