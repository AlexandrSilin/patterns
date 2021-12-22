package Creational.factories.abstractFactory.doors;

import Creational.factories.abstractFactory.experts.DoorFittingExpert;

public interface DoorFactory {
    Door makeDoor();

    DoorFittingExpert makeExpert();
}
