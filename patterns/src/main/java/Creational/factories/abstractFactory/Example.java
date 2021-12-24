package Creational.factories.abstractFactory;

import Creational.factories.abstractFactory.doors.DoorFactory;
import Creational.factories.abstractFactory.doors.IronDoorFactory;
import Creational.factories.abstractFactory.doors.WoodenDoorFactory;

public class Example {
    public static void main(String[] args) {
        DoorFactory woodenDoorFactory = new WoodenDoorFactory();
        DoorFactory ironDoorFactory = new IronDoorFactory();
        System.out.println(woodenDoorFactory.makeDoor());
        woodenDoorFactory.makeExpert().getDescription();
        System.out.println(ironDoorFactory.makeDoor());
        ironDoorFactory.makeExpert().getDescription();
    }
}
