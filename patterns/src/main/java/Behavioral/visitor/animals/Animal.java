package Behavioral.visitor.animals;

import Behavioral.visitor.AnimalOperation;

public abstract class Animal {
    protected final String voice;

    protected Animal(String voice) {
        this.voice = voice;
    }

    public abstract void accept(AnimalOperation animalOperation);

    public void voice() {
        System.out.println(voice);
    }
}
