package Creational.builder;

public class Burger {
    private boolean cheese;
    private boolean pepperoni;
    private boolean lettuce;
    private boolean tomato;

    private Burger() {

    }

    public static BurgerBuilder getBuilder() {
        return new BurgerBuilder();
    }

    @Override
    public String toString() {
        return "Burger{" +
                "cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", lettuce=" + lettuce +
                ", tomato=" + tomato +
                '}';
    }

    public static class BurgerBuilder {
        private final Burger burger = new Burger();

        private BurgerBuilder() {

        }

        public BurgerBuilder withCheese() {
            burger.cheese = true;
            return this;
        }

        public BurgerBuilder withPepperoni() {
            burger.pepperoni = true;
            return this;
        }

        public BurgerBuilder withLettuce() {
            burger.lettuce = true;
            return this;
        }

        public BurgerBuilder withTomato() {
            burger.tomato = true;
            return this;
        }

        public Burger build() {
            return burger;
        }
    }
}
