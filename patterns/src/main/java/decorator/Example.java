package decorator;

import decorator.coffee.*;

public class Example {
    public static void main(String[] args) {
        Coffee coffee = new VanillaCoffee(new WhipCoffee(new MilkCoffee(new SimpleCoffee(10))));
        System.out.println(coffee.getDescription() + ". Cost: " + coffee.getCost());
    }
}
