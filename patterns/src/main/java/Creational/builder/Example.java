package Creational.builder;

public class Example {
    public static void main(String[] args) {
        System.out.println(Burger.getBuilder().withCheese().withLettuce().withTomato().build());
    }
}
