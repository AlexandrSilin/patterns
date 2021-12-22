package Behavioral.visitor;

import Behavioral.visitor.animals.Animal;
import Behavioral.visitor.animals.Dolphin;
import Behavioral.visitor.animals.Lion;
import Behavioral.visitor.animals.Monkey;
import Behavioral.visitor.visitors.Jump;
import Behavioral.visitor.visitors.Speak;

import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        AnimalOperation speak = new Speak();
        AnimalOperation jump = new Jump();
        List<Animal> animals = new ArrayList<>();
        animals.add(new Monkey());
        animals.add(new Dolphin());
        animals.add(new Lion());
        for (Animal animal : animals) {
            animal.accept(speak);
            animal.accept(jump);
        }
    }
}
