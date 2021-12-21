package Structural.adapter;

import Structural.adapter.dogs.WildDog;
import Structural.adapter.lions.AfricanLion;
import Structural.adapter.lions.AsianLion;
import Structural.adapter.lions.Lion;

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
