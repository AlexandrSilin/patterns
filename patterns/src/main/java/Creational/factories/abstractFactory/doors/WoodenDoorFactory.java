package Creational.factories.abstractFactory.doors;

import Creational.factories.abstractFactory.experts.Carpenter;
import Creational.factories.abstractFactory.experts.DoorFittingExpert;

public class WoodenDoorFactory implements DoorFactory {
    @Override
    public Door makeDoor() {
        return new WoodenDoor();
    }

    @Override
    public DoorFittingExpert makeExpert() {
        return new Carpenter();
    }
}
