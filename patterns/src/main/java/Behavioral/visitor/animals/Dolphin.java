package Behavioral.visitor.animals;

import Behavioral.visitor.AnimalOperation;

public class Dolphin extends Animal {
    public Dolphin() {
        super("Tuut tuttu tuutt!");
    }

    @Override
    public void accept(AnimalOperation animalOperation) {
        animalOperation.visitDolphin(this);
    }
}
