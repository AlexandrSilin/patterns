package Creational.prototype;

public class Example {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("sheep", 2);
        System.out.println(sheep);
        System.out.println(sheep.clone());
    }
}
