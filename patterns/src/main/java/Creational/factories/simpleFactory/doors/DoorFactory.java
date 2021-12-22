package Creational.factories.simpleFactory.doors;

public class DoorFactory {
    private DoorFactory() {

    }

    public static Door createDoor(float width, float height) {
        return new WoodenDoor(width, height);
    }
}
