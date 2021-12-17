package adapter;

import adapter.dogs.WildDog;
import adapter.lions.AfricanLion;
import adapter.lions.AsianLion;
import adapter.lions.Lion;

import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<Lion> lionList = new ArrayList<>();
        lionList.add(new AfricanLion());
        lionList.add(new AsianLion());
        lionList.add(new WildDogAdapter(new WildDog()));
        Hunter hunter = new Hunter();
        lionList.forEach(hunter::hunt);
    }
}
