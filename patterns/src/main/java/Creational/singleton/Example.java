package Creational.singleton;

public class Example {
    public static void main(String[] args) {
        System.out.println(President.getInstance());
        System.out.println(PresidentEnum.INSTANCE);
    }
}
