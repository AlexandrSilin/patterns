package adapter;

import adapter.dogs.WildDog;
import adapter.lions.Lion;

public class WildDogAdapter implements Lion {
    private WildDog dog;

    public WildDogAdapter(WildDog dog) {
        this.dog = dog;
    }

    @Override
    public void roar() {
        dog.bark();
    }
}
