package Behavioral.strategy;

public class BubbleSortStrategy implements SortStrategy {
    @Override
    public String[] sort(String[] array) {
        System.out.println("Bubble sort");
        return array;
    }
}
