package Structural.decorator.coffee;

public class WhipCoffee extends Coffee {
    private Coffee coffee;

    public WhipCoffee(Coffee coffee) {
        this.coffee = coffee;
        this.cost = coffee.getCost() + 5;
        this.description = coffee.getDescription() + ", whip";
    }
}
