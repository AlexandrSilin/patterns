package decorator.coffee;

public class MilkCoffee extends Coffee {
    private final Coffee coffee;

    public MilkCoffee(Coffee coffee) {
        this.coffee = coffee;
        this.cost = coffee.getCost() + 2;
        this.description = coffee.getDescription() + ", with milk";
    }
}
