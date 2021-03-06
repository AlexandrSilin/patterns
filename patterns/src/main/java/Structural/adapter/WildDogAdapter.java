package Structural.adapter;

import Structural.adapter.dogs.WildDog;
import Structural.adapter.lions.Lion;

public class WildDogAdapter implements Lion {
    private final WildDog dog;

    public WildDogAdapter(WildDog dog) {
        this.dog = dog;
    }

    @Override
    public void roar() {
        dog.bark();
    }
}
