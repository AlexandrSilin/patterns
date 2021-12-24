package Behavioral.visitor.animals;

import Behavioral.visitor.AnimalOperation;

public class Monkey extends Animal {
    public Monkey() {
        super("Ooh oo aa aa!");
    }

    @Override
    public void accept(AnimalOperation animalOperation) {
        animalOperation.visitMonkey(this);
    }
}
