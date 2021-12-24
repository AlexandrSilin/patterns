package Creational.factories.abstractFactory.doors;

import Creational.factories.abstractFactory.experts.DoorFittingExpert;
import Creational.factories.abstractFactory.experts.Welder;

public class IronDoorFactory implements DoorFactory {
    @Override
    public Door makeDoor() {
        return new IronDoor();
    }

    @Override
    public DoorFittingExpert makeExpert() {
        return new Welder();
    }
}
