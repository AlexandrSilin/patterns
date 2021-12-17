package decorator.coffee;

public class VanillaCoffee extends Coffee {
    private Coffee coffee;

    public VanillaCoffee(Coffee coffee) {
        this.coffee = coffee;
        this.cost = coffee.getCost() + 3;
        this.description = coffee.getDescription() + ", vanilla";
    }
}
