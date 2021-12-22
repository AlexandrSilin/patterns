package Behavioral.visitor.animals;

import Behavioral.visitor.AnimalOperation;

public class Lion extends Animal {
    public Lion() {
        super("Roaaar!");
    }

    @Override
    public void accept(AnimalOperation animalOperation) {
        animalOperation.visitLion(this);
    }
}
