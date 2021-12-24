package Creational.factories.simpleFactory;

import Creational.factories.simpleFactory.doors.DoorFactory;

public class Example {
    public static void main(String[] args) {
        System.out.println(DoorFactory.createDoor(123, 200));
    }
}
